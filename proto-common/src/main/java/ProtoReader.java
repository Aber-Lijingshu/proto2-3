import com.google.protobuf.CodedInputStream;
import proto2.Proto2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author jpitz
 */
public class ProtoReader {
    public static void main(String[] args) throws Exception {
        // TODO: pull somewhere common and set more then just a string
        final Proto2.ServiceRequest expectedRequest = Proto2.ServiceRequest.newBuilder()
                .setMessage("Testing")
                .build();

        final String filenameBase = args[0];

        {
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(new File(filenameBase + "-Data.bin")))) {
                final int size = dis.readInt();
                final byte[] val = new byte[size];
                dis.readFully(val);

                final Proto2.ServiceRequest actualRequest = Proto2.ServiceRequest.parseFrom(val);
                assert expectedRequest.getMessage().equals(actualRequest.getMessage());
            }
        }

        System.out.println("Successfully read and asserted contents of -Data.bin file");

        {
            try (final FileInputStream dis = new FileInputStream(new File(filenameBase + "-File.bin"))) {
                final Proto2.ServiceRequest actualRequest = Proto2.ServiceRequest.parseFrom(dis);
                assert expectedRequest.getMessage().equals(actualRequest.getMessage());
            }
        }

        System.out.println("Successfully read and asserted contents of -File.bin file");

        {
            try (final FileInputStream dis = new FileInputStream(new File(filenameBase + "-Coded.bin"))) {
                final CodedInputStream cis = CodedInputStream.newInstance(dis);
                final Proto2.ServiceRequest actualRequest = Proto2.ServiceRequest.parseFrom(cis);
                assert expectedRequest.getMessage().equals(actualRequest.getMessage());
            }
        }

        System.out.println("Successfully read and asserted contents of -Coded.bin file");

        System.out.println("Successfully read and asserted contents for all files");
    }
}

import com.google.protobuf.CodedOutputStream;
import proto2.Proto2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author jpitz
 */
public class ProtoWriter {
    public static void main(String[] args) throws Exception {
        final Proto2.ServiceRequest request = ProtoMessage.expectedRequest;

        final String filenameBase = args[0];

        try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(filenameBase + "-Data.bin")))) {
            final byte[] val = request.toByteArray();
            dos.writeInt(val.length);
            dos.write(val);
        }

        System.out.println("Successfully wrote -Data.bin file");

        try (final FileOutputStream dos = new FileOutputStream(new File(filenameBase + "-File.bin"))) {
            request.writeTo(dos);
        }

        System.out.println("Successfully wrote -File.bin file");

        try (final FileOutputStream dos = new FileOutputStream(new File(filenameBase + "-Coded.bin"))) {
            final CodedOutputStream cos = CodedOutputStream.newInstance(dos);
            request.writeTo(cos);
            cos.flush();
        }

        System.out.println("Successfully wrote -Coded.bin file");

        System.out.println("Successfully wrote all files");
    }
}

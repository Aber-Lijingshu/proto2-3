import com.google.protobuf.ByteString;
import proto2.Proto2;

/**
 * @author jpitz
 */
public interface ProtoMessage {
    Proto2.ServiceRequest expectedRequest = Proto2.ServiceRequest.newBuilder()
            .setMessage("hello world!")
            .setDouble(2)
            .setFloat(3)
            .setInt32(4)
            .setInt64(5)
            .setUint32(6)
            .setUint64(7)
            .setSint32(8)
            .setSint64(9)
            .setFixed32(10)
            .setFixed64(11)
            .setSfixed32(12)
            .setSfixed64(13)
            .setBool(true)
            .setBytes(ByteString.copyFromUtf8("hello world!"))
            .build();
}

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

// Define the LowercaseInputStream class (not public)
class LowercaseInputStream extends InputStream {
    private InputStream inputStream;

    public LowercaseInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        int data = inputStream.read();
        if (data == -1) {
            return -1; // End of stream
        }
        return Character.toLowerCase((char) data);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int bytesRead = inputStream.read(b, off, len);
        if (bytesRead == -1) {
            return -1; // End of stream
        }
        for (int i = off; i < off + bytesRead; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return bytesRead;
    }
}

// Public class must be named LowercaseInputStreamExample
public class upperToLower {
    public static void main(String[] args) {
        String input = "HELLO WORLD!";
        InputStream originalStream = new ByteArrayInputStream(input.getBytes());
        InputStream lowercaseStream = new LowercaseInputStream(originalStream);

        try {
            int data;
            while ((data = lowercaseStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

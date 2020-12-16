package logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import exceptions.LoggingException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Singleton
public class FastLogger implements ILogger {

    private final String identifier;
    private final OutputStream stream;
    private final byte[] buffer;
    private int currentSize;

    @Inject
    public FastLogger(@Named("logger.fast.identifier") final String identifier,
                      @Named("console-output-stream") final OutputStream stream, //@Named("console-output-stream")
                      @Named("logger.fast.buffer.size") final Integer bufferSize) {
        this.identifier = identifier;
        this.stream = stream;
        this.buffer = new byte[bufferSize];
        this.currentSize = 0;
    }



    private void flush(){
        try {
            stream.write(buffer);
            stream.flush();
            currentSize = 0;
        } catch(IOException ex) {
            throw new LoggingException(ex);
        }
    }

    @Override
    public boolean close() {
        try {

            stream.write(buffer);
            stream.close();
        } catch(IOException ex) {
            throw new LoggingException(ex);
        }
        return false;
    }

    @Override
    public boolean write(String data) {
        final byte[] bytes = (identifier + " " + data + "\n").getBytes();

        if(currentSize + bytes.length > buffer.length) {
            return false;
        }

        System.arraycopy(bytes, 0, buffer, currentSize, bytes.length);
        currentSize+= bytes.length;
        return true;

    }

    @Override
    public CompletableFuture<Void> flushAsync() {
        return CompletableFuture.runAsync(this::flush);
    }


}

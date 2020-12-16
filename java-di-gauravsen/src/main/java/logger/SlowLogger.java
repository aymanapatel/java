package logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import exceptions.LoggingException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Singleton
public class SlowLogger implements ILogger {

    private final String identifier;
    private final OutputStream outputStream;
    private final List<String> buffer;


    public SlowLogger(String identifier, OutputStream outputStream) {
        this.identifier = identifier;
        this.outputStream = outputStream;
        //this.buffer = buffer;
        buffer = new ArrayList<>();
    }




    @Override
    public boolean write(final String word) {
        buffer.add(identifier + " : " + word + "\n");
        return true;
    }

    @Override
    public CompletableFuture<Void> flushAsync() {
        CompletableFuture<Void> result = CompletableFuture.completedFuture(null);
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (final String word: buffer) {

            result = result.thenAcceptAsync(__ -> {
                try {
                    Thread.sleep(100);
                    outputStream.write(word.getBytes());

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }, service);
        }
        return result;
    }

    @Override
    public boolean close() {
        try {
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException ex) {
            throw new LoggingException(ex);
        }
        return false;
    }


}

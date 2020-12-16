package logger;

import java.util.concurrent.CompletableFuture;

public interface ILogger {
    
    boolean write(String data);

    CompletableFuture<Void> flushAsync();

    boolean close();
}

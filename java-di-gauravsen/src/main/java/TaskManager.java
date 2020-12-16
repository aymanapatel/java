import com.google.inject.Inject;
import com.google.inject.Singleton;
import logger.ILogger;
import logger.SlowLogger;

import java.util.concurrent.CompletableFuture;

@Singleton
public class TaskManager {

    private final ILogger logger;



    @Inject
    public TaskManager(final ILogger logger) {
        this.logger = logger;
    }

    public CompletableFuture<Void>  execute() {
        final String[] sentence = "This is a tutorial on DI by Gaurav!".split(" ");

        for(final String word: sentence){
            logger.write(word);
        }

        return logger.flushAsync()
                     .whenComplete((__, throwable) -> {
                        if(throwable != null) {
                            throwable.printStackTrace();
                        }
                        else {
                            logger.close();
                        }

                     });
    }
}

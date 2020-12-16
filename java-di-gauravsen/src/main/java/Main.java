

import com.google.inject.Guice;
import com.google.inject.Injector;

import logger.SlowLogger;
import modules.LoggingModule;
import modules.PropertiesModule;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //                                           Yellow                  Green
        Injector injector = Guice.createInjector(new PropertiesModule(), new LoggingModule());
        final TaskManager taskManager = injector.getInstance(TaskManager.class);
        taskManager.execute().get();

    }
}

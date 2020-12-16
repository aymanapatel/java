
package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
//import logger.FastLogger;
import logger.FastLogger;
import logger.ILogger;
import logger.SlowLogger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class LoggingModule extends AbstractModule {

    @Override //configuration
    public void configure() {
        bind(ILogger.class).to(FastLogger.class);
    }

    @Provides // factory method
    @Named("file-output-stream")
    public OutputStream getOutputStream(@Named("output-file.name") String fileLocation) throws FileNotFoundException {
        return new FileOutputStream(fileLocation);
    }

    @Provides // factory method
    @Named("console-output-stream")
    public OutputStream getConsoleOutputStream(@Named("output-file.name") String fileLocation){
        return System.out;
    }
}
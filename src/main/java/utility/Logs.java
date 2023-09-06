package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Logger class
public class Logs {
		public static Logger Log = LogManager.getLogger();

		// Methods for all log levels
		public static void Info(String message) {
			Log.info(message);
		}

		public static void Warn(String message) {
		    Log.warn(message);
		}

		public static void Error(String message) {
		    Log.error(message);
		}     

		public static void Fatal(String message) {
		    Log.fatal(message);		    
		}
		
		public static void Debug(String message) {
		    Log.debug(message);
		}
}

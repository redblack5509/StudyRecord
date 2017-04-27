package com.niuc.basical.yichang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Description: 
 * @Date:2017Äê4ÔÂ12ÈÕ
 * @author niuc
 *
 */
public class LoggingException {
	public static void main(String[] args) {
		try {
			throw new LoggingExcep();
		} catch (LoggingExcep e) {
			System.err.println("Caught " + e);
		}
		try {
			throw new LoggingExcep();
		} catch (LoggingExcep e) {
			System.err.println("Caught " + e);
		}
	}
}

class LoggingExcep extends Exception {
	private static Logger logger = Logger.getLogger("LoggingExcep");
	public LoggingExcep() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}






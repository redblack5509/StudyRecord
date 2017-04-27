package com.niuc.basical.yichang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Description: 异常处理中的日志记录
 * @Date:2017�?4�?12�?
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






package org.java.WebCalculator.webCalc.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.java.WebCalculator.webCalc.CalcServlet;

public class CalcService {
	private static Logger logger = Logger
			.getLogger(CalcService.class.getName());
	private double num1;
	private double num2;

	public CalcService(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public String add() {
		return num1 + num2 + "";
	}

	public String subtract() {
		return num1 - num2 + "";
	}

	public String multiply() {
		return num1 * num2 + "";
	}

	public String divide() {
		if (num2 == 0) {
			logger.log(Level.WARNING, "Second number is 0. Can't divide by 0!");
			CalcServlet.errMes = " \"Can't divide by 0!\" ";
			return "\" \"";
		} else {
			return num1 / num2 + "";
		}
	}
}

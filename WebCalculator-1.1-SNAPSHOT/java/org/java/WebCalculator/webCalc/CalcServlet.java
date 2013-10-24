package org.java.WebCalculator.webCalc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.WebCalculator.webCalc.service.CalcService;

public class CalcServlet extends HttpServlet {
	private static Logger logger = Logger
			.getLogger(CalcServlet.class.getName());

	public static String errMes = " \" \" ";

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String result = "\" \"";
		double num1 = 0;
		double num2 = 0;
		String firstNumber = req.getParameter("firstNumber");
		String secondNumber = req.getParameter("secondNumber");

		if (checkType(firstNumber) && checkType(secondNumber)) {
			num1 = Double.parseDouble(firstNumber);
			num2 = Double.parseDouble(secondNumber);

			CalcService obj = new CalcService(num1, num2);

			if (req.getParameter("operation").equals("add")) {
				result = obj.add();
			} else if (req.getParameter("operation").equals("subtract")) {
				result = obj.subtract();
			} else if (req.getParameter("operation").equals("multiply")) {
				result = obj.multiply();
			} else {
				result = obj.divide();
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(
				"{\"result\":" + result + ", \"err\": " + errMes + " }");
	}

	public boolean checkType(String number) {
		try {
			Double.parseDouble(number);
			errMes = " \" \" ";
			return true;
		} catch (Exception e) {
			if (number.isEmpty()) {
				logger.log(Level.WARNING,
						"One or both numbers are not entered!");
				errMes = " \"Please enter both numbers\" ";
				return false;
			} else {
				logger.log(Level.WARNING,
						"One or both numbers are invalid. Use only numbers and signs '-', '.'! ");
				errMes = " \"You entered invalid number.\" ";
				return false;
			}
		}
	}

}

package Calculator_proj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map the servlet to a URL
@WebServlet("/CalculatorServlet")
public class Calculator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve parameters from the form
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");
        String resultMessage;

        try {
            // Convert inputs to numbers
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result;

            // Perform the selected operation
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    resultMessage = "The result of addition is: " + result;
                    break;
                case "subtract":
                    result = num1 - num2;
                    resultMessage = "The result of subtraction is: " + result;
                    break;
                case "multiply":
                    result = num1 * num2;
                    resultMessage = "The result of multiplication is: " + result;
                    break;
                case "divide":
                    if (num2 == 0) {
                        resultMessage = "Error: Division by zero is not allowed.";
                    } else {
                        result = num1 / num2;
                        resultMessage = "The result of division is: " + result;
                    }
                    break;
                default:
                    resultMessage = "Invalid operation.";
            }
        } catch (NumberFormatException e) {
            resultMessage = "Error: Invalid number format. Please enter valid numbers.";
        }

        // Set the response content type
        response.setContentType("text/html");
        
        // Display the result to the user
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Calculator Result</h2>");
        response.getWriter().println("<p>" + resultMessage + "</p>");
        response.getWriter().println("<a href='index.jsp'>Go Back</a>");
        response.getWriter().println("</body></html>");
    }
}

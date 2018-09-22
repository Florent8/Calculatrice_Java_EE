package servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Calculatrice : HttpServlet() {
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) = forward(request, response)

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        request.characterEncoding = "UTF-8"
        val paramNumber1 = request.getParameter("number1")
        val number1 = if (paramNumber1.isEmpty()) 0 else paramNumber1.toInt()
        val operator = request.getParameter("operator")
        val paramNumber2 = request.getParameter("number2")
        val number2 = if (paramNumber2.isEmpty()) 0 else paramNumber2.toInt()
        request.setAttribute("result", "$number1 $operator ${if (number2 < 0) "($number2)" else number2.toString()} = ${when (operator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "x" -> number1 * number2
            "÷" -> try {
                number1 / number2
            } catch (e: ArithmeticException) {
                "Division par zéro."
            }
            "mod" -> try {
                number1 % number2
            } catch (e: ArithmeticException) {
                "Division par zéro"
            }
            else -> throw IllegalArgumentException("Operator \"$operator\" is no valid.")
        }}")
        forward(request, response)
    }

    private fun forward(request: HttpServletRequest, response: HttpServletResponse) =
            servletContext.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response)
}

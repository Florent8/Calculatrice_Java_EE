package servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Calculatrice : HttpServlet() {
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) = forward(request, response)

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        request.characterEncoding = "UTF-8"
        val number1 = request.getParameter("number1").toInt()
        val operator = request.getParameter("operator")
        val number2 = request.getParameter("number2").toInt()
        request.setAttribute("result", "$number1 $operator ${if (number2 < 0) "($number2)" else number2.toString()} = ${when (operator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "x" -> number1 * number2
            "÷" -> number1 / number2
            "mod" -> number1 % number2
            else -> throw IllegalArgumentException("Operator \"$operator\" is no valid.")
        }}")
        forward(request, response)
    }

    private fun forward(request: HttpServletRequest, response: HttpServletResponse) =
            servletContext.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response)
}

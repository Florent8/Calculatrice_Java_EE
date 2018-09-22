package servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Calculatrice : HttpServlet() {
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) = forward(request, response)

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val number1 = request.getParameter("number1").toInt()
        val number2 = request.getParameter("number2").toInt()
        request.setAttribute("result", "<p>$number1+$number2=${number1 + number2}</p>")
        forward(request, response)
    }

    fun forward(request: HttpServletRequest, response: HttpServletResponse) =
            servletContext.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response)
}

package io.github.lhotari.hello

import javax.servlet.GenericServlet
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletResponse

@WebServlet("/")
class HelloServlet extends GenericServlet {
    @Override
    void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        def shell = new GroovyShell()
        500.times {
        shell.evaluate "x = 100"
        }
        
        def out=((HttpServletResponse)res).writer
        out << "Hello world!"
        out.close()
    }
}

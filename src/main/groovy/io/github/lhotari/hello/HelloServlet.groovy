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
        
        def tmp = [:]
        def mymap = [:]
        for (i = 0; i <1000000; i++) {
        mymap.put(new Integer(i), new String(" New String"))
        tmp.put(new Integer(i),mymap.get(i));
}
        
        def out=((HttpServletResponse)res).writer
        out << "Hello world!"
        out.close()
    }
}

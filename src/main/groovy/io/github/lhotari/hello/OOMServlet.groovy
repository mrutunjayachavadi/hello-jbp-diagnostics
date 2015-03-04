package io.github.lhotari.hello

import javax.servlet.GenericServlet
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletResponse

@WebServlet("/cause-oom")
class OOMServlet extends GenericServlet {

    static List<byte[]> container=[]

    @Override
    void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        def out=((HttpServletResponse)res).writer
        out << "Causing OOM"
        out.flush()
        while(true) {
            container.add(new byte[50000000])
            Thread.sleep(50)
        }
        out.close()
    }
}

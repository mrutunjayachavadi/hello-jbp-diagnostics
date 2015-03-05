package io.github.lhotari.hello

import javax.servlet.GenericServlet
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletResponse

@WebServlet("/allocmem")
class AllocMemServlet extends GenericServlet {
    @Override
    void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        def out=((HttpServletResponse)res).writer
        List<byte[]> container=[]
        out << "Causing OOM by allocating to local variable. Memory is available after thread crashes with OOME."
        out.flush()
        while(true) {
            container.add(new byte[5000000])
            out.print(".")
            out.flush()
            Thread.sleep(50)
        }
        out.close()
    }
}

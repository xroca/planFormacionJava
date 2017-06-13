package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

/**
 *
 * @author user
 */
public class EjemploServletTest {

    private EjemploServlet ejemploServlet;

    public EjemploServletTest() {
    }

    @Before
    public void setUp() {
        ejemploServlet = new EjemploServlet();
    }

    @Test
    public void testEjemploServlet() throws ServletException, IOException {
        HttpServletRequest mockRequest = createStrictMock(HttpServletRequest.class);
        RequestDispatcher mockRequestDispatcher = createStrictMock(RequestDispatcher.class);

        expect(mockRequest.getParameter("primerNombre")).andReturn("unNombre");
        expect(mockRequest.getParameter("segundoNombre")).andReturn("unApellido");

        mockRequest.setAttribute("primerNombre", "unNombre");
        mockRequest.setAttribute("segundoNombre", "unApellido");

        expect(mockRequest.getRequestDispatcher("/ver.jsp")).andReturn(mockRequestDispatcher);


        replay(mockRequest);

        ejemploServlet.doPost(mockRequest, null);

        verify(mockRequest);

        reset(mockRequest, mockRequestDispatcher);
    }
}

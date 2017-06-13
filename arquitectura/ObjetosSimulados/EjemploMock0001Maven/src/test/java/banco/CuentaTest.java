/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import banco.implementacion.ServicioCuentaImpl;
import junit.framework.TestCase;
import org.easymock.EasyMock;

/**
 *
 * @author jose maria
 */
public class CuentaTest extends TestCase {

    private Cuenta mockCuenta;
    private CuentaDao mockDao;
    private ServicioCuentaImpl servicioCuenta;

    public CuentaTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mockCuenta = EasyMock.createNiceMock(Cuenta.class);
        mockDao = EasyMock.createNiceMock(CuentaDao.class);
        servicioCuenta = new ServicioCuentaImpl();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testConcederPrestamo() {
        assertNotNull(mockCuenta);
        assertNotNull(mockDao);
        EasyMock.expect(mockCuenta.saldoMedio(3)).andReturn(1000.0d);
        EasyMock.expect(mockDao.encontrarCuentaPorId(1L)).andReturn(mockCuenta);
        EasyMock.replay(mockCuenta, mockDao);
        servicioCuenta.setCuentaDao(mockDao);
        assertTrue(servicioCuenta.concederPrestamo(500.0d, 1L));
        EasyMock.verify(mockCuenta, mockDao);
        EasyMock.reset(mockCuenta, mockDao);
    }

    public void testDenegarPrestamo() {
        assertNotNull(mockCuenta);
        assertNotNull(mockDao);
        EasyMock.expect(mockCuenta.saldoMedio(3)).andReturn(1000.0d);
        EasyMock.expect(mockDao.encontrarCuentaPorId(1L)).andReturn(mockCuenta);
        EasyMock.replay(mockCuenta, mockDao);
        servicioCuenta.setCuentaDao(mockDao);
        assertFalse(servicioCuenta.concederPrestamo(1500.0d, 1L));
        EasyMock.verify(mockCuenta, mockDao);
        EasyMock.reset(mockCuenta, mockDao);
    }
}

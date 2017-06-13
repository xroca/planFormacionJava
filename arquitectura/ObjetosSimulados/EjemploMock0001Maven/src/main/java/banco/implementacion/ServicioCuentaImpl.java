/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.implementacion;

import banco.Cuenta;
import banco.CuentaDao;
import banco.ServicioCuenta;

/**
 *
 * @author jose maria
 */
public class ServicioCuentaImpl implements ServicioCuenta {

    private CuentaDao dao;

    public void setCuentaDao(CuentaDao dao) {
        this.dao = dao;
    }

    public Boolean concederPrestamo(Double cantidad, Long idCuenta) {
        Cuenta cuenta = dao.encontrarCuentaPorId(idCuenta);
        Integer periodoDeCalculoEstandar = 3;
        Double saldoMedio = cuenta.saldoMedio(periodoDeCalculoEstandar);
        return saldoMedio < cantidad ? false : true;
    }
}

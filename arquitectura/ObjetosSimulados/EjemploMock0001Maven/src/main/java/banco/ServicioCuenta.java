/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author jose maria
 */
public interface ServicioCuenta {

    Boolean concederPrestamo(Double cantidad, Long idCuenta);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public String businessMethodfinal(String t) {
        return "El texto es " + t;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

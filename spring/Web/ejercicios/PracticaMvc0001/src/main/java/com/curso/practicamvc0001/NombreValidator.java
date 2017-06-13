/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicamvc0001;

import com.curso.practicamvc0001.modelo.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author usuario
 */
@Component
public class NombreValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario u = (Usuario) target;
        System.out.println("Validando " + u);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "", "Nombre vacio");
        if (u.getNombre().length() < 5) {
            errors.rejectValue("nombre", "", "La longitud es menor que 5");
        }
    }

}

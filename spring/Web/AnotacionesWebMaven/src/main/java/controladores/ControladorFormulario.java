/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import beans.Persona;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import validaciones.PersonaValidator;

/**
 *
 * @author Chema
 */
@Controller
@RequestMapping("/cuarta.html")
@SessionAttributes("persona")
public class ControladorFormulario {

    @Autowired
    private PersonaValidator personaValidator;

    @InitBinder
    private void binding(WebDataBinder w) {
        w.setValidator(personaValidator);
    }
    @Autowired
    private Persona persona;

    @ModelAttribute("persona")
    public Persona getPersona() {
        return persona;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String manejadorGet() {
        return "formulario";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String procesarFormulario(@ModelAttribute("persona") Persona persona, BindingResult errores, SessionStatus estado) {
//        new PersonaValidator().validate(persona, errores);
//        if (errores.hasErrors()) {
//            return "formulario";
//        } else {
//            estado.setComplete();
//            return "redirect:redirect.jsp";
//        }
//    }
    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(@ModelAttribute("persona") @Valid Persona persona, BindingResult errores, SessionStatus estado) {
        if (errores.hasErrors()) {
            return "formulario";
        } else {
            estado.setComplete();
            return "redirect:redirect.jsp";
        }
    }
}

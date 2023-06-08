package com.jtarazona.backendDevTest.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomErrorController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String handleError() {
        // Lógica para manejar el error y devolver una respuesta personalizada
        return "Error personalizado";
    }
    
    
    
    public String getErrorPath() {
        return null;
    }
}

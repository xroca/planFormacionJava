/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.beans;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServicioPlanificado {

    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        System.out.println("En fixed rate. Son las " + new Date());
    }

    @Scheduled(fixedDelay = 7000)
    public void fixedDelay() {
        System.out.println("En fixed delay. Son las " + new Date());
    }

    @Scheduled(cron = "*/3 * * * * ?")
    public void cron() {
        System.out.println("En cron. Son las " + new Date());
    }
}

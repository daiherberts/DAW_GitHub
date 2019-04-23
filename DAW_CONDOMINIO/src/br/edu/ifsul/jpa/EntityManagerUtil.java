/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daiah
 */
public class EntityManagerUtil {
        private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager(){
        if (emf ==null){
            emf = Persistence.createEntityManagerFactory("DAW-TESTE");//nome BD
        }
        if (em ==null){
            em = emf.createEntityManager();
        }
        return em;
    }
    
}

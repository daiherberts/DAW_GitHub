/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Recurso;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TesteListarRecurso {
    
    EntityManager em;
    
    public TesteListarRecurso() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void recuperar(){
    List<Recurso> pessoas = em.createQuery("from Recurso").getResultList();//usar nome da CLASSE
        for(Recurso r: pessoas){
            System.out.println(r+"\n");
        }
    
    }
}


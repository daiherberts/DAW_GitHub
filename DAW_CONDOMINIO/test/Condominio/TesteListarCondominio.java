/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Condominio;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daiah
 */
public class TesteListarCondominio {
    
    EntityManager em;
    
    public TesteListarCondominio() {
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
    List<Condominio> condominios = em.createQuery("from Condominio").getResultList();
        for(Condominio c: condominios){
            System.out.println(c+"\n");
        }
    }   
}


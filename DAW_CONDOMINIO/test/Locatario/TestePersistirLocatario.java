/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locatario;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daiah
 */
public class TestePersistirLocatario {
    EntityManager em;
    
    public TestePersistirLocatario() {
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
    public void incluir(){
        try {
        Locatario obj = new Locatario();
            obj.setNome("Locatarios");
            obj.setCpf("868.095.440-38");//usar CPF válido
            obj.setTelefone("(54)91123-9876");
            obj.setEmail("locatarios@gmail.com");
            obj.setRenda(1800.00);
            obj.setLocalTrabalho("Disney");
            obj.setTelefoneTrabalho("(54)3328-8020");
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            
            e.printStackTrace();

        }
    }
}


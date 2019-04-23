package Pessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TestePersistirPessoa {
    EntityManager em;
    
    public TestePersistirPessoa() {
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
            Pessoa obj = new Pessoa();
            obj.setNome("Chorando");
            obj.setCpf("015.939.290-05");
            obj.setTelefone("(54)99999-3333");
            obj.setEmail("teste2@teste.com");
           
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
       
    }
    
}

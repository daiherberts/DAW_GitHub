/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TesteRemoverPessoa {
    
    EntityManager em;
    
    public TesteRemoverPessoa() {
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
    public void apagar(){
        
        try {
            Pessoa p = em.find(Pessoa.class, 1);
        em.getTransaction().begin(); 
        em.remove(p); // remover no BD
        em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    
    }
}

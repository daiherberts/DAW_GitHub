/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pessoa;
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
public class TesteListaPessoa {
    
    EntityManager em;
    
    public TesteListaPessoa() {
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
    List<Pessoa> pessoas = em.createQuery("from Pessoa").getResultList();
        for(Pessoa p: pessoas){
            System.out.println(p+"\n");
        }
    
    }
}

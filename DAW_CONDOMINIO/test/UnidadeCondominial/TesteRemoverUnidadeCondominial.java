/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadeCondominial;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.UnidadeCondominial;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TesteRemoverUnidadeCondominial {
    
    EntityManager em;
    
    public TesteRemoverUnidadeCondominial() {
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
        UnidadeCondominial uc = em.find(UnidadeCondominial.class, 3);
        em.getTransaction().begin(); 
        em.remove(uc); // remover no BD
        em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    
    }
    
}

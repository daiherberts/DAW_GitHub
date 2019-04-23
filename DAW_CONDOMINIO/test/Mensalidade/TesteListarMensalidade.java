/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensalidade;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Mensalidade;
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
public class TesteListarMensalidade {
    
    EntityManager em;
    
    public TesteListarMensalidade() {
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
    List<Mensalidade> mensalidades = em.createQuery("from Mensalidade").getResultList();
        for(Mensalidade m: mensalidades){
            System.out.println(m+"\n");
        }
    
    }
    
}

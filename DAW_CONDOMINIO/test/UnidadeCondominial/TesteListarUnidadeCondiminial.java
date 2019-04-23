/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadeCondominial;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.UnidadeCondominial;
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
public class TesteListarUnidadeCondiminial {
    
    EntityManager em;
    
    public TesteListarUnidadeCondiminial() {
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
    List<UnidadeCondominial> pessoas = em.createQuery("from UnidadeCondominial").getResultList();//usar nome da CLASSE
        for(UnidadeCondominial uc: pessoas){
            System.out.println(uc+"\n");
        }
    
    }
}

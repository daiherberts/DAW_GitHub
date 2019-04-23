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
public class TesteEditarUnidadeCondominial {
    
    EntityManager em;
    
    public TesteEditarUnidadeCondominial() {
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
    public void atualizar(){
      
        try{
        UnidadeCondominial uc = em.find(UnidadeCondominial.class, 1);
        uc.setNumero("790");
        uc.setDescricao("atualizar unidade");
        uc.setArea(100.48);
        uc.setNumero("8");

        em.getTransaction().begin();
        em.merge(uc); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro: "+e);
            e.printStackTrace();
    
        }
    }
}

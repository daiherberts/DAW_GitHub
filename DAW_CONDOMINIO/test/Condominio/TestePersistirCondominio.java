/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Condominio;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recurso;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TestePersistirCondominio {
    
   EntityManager em;

    public TestePersistirCondominio() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void incluir(){
        try {
            Condominio obj = new Condominio();
            obj.setNome("nao aguento maaaaais 3");
            obj.setEndereco("Av. Condominio AAA");
            obj.setNumero("984");
            obj.setCep("99062390");
            
            //persistir Unidade Condominal em Condominio
            obj.addUC(em.find(UnidadeCondominial.class, 2));
            obj.adicionarCR(em.find(Recurso.class, 3));
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("--ERRO\n"+e);
        }
      
       
    }

}
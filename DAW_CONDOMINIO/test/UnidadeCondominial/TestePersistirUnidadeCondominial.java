/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadeCondominial;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirUnidadeCondominial {
    
    EntityManager em;

    public TestePersistirUnidadeCondominial() {
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
    public void teste(){
        try {
            UnidadeCondominial obj = new UnidadeCondominial();
            obj.setNumero("806");
            obj.setDescricao("ainda chorando chorando");
            obj.setArea(175.10);
            obj.setNumeroQuarto(3);
            obj.setCondominio(em.find(Condominio.class, 1));
            
            
            
            //PERSISTIR PROPRIETARIO - ERRO!!!!!!
            /*
            Pessoa prod = new Pessoa();
            prod.setNome("Teste Proprietario");
            prod.setCpf("015.939.290-05");
            prod.setTelefone("3313-2243");
            prod.setEmail("proprietario@teste.com");

            obj.adicionarProprietario(prod);*/
                    
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

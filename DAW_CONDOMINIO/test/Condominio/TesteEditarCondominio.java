/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Condominio;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TesteEditarCondominio {
    
    EntityManager em;
    
    public TesteEditarCondominio() {
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
        Condominio c = em.find(Condominio.class, 1);
        c.setNome("Editar Condominio"); 
        c.setEndereco("av principal");
        c.setNumero("732");
        c.setCep("99073-060");
     
        em.getTransaction().begin();
        em.merge(c); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro: "+e);
            e.printStackTrace();
        }
    }
}
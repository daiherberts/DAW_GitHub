/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locatario;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Locatario;
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
public class TesteEditarLocatario {
    
    EntityManager em;
    
    public TesteEditarLocatario() {
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
        Locatario l = em.find(Locatario.class, 6);
        l.setNome("TesteEditar"); //altera em tabela Pessoa
        l.setCpf("723.914.140-30");//altera em tabela Pessoa
        l.setEmail("atualizar@gmail.com");//altera em tabela Pessoa
        l.setTelefone("5433111189");//altera em tabela Pessoa
        l.setRenda(1000.00);
        l.setLocalTrabalho("WallDisney");
        l.setTelefoneTrabalho("33284556");
        l.setTelefoneTrabalho("54984373991");
        

        em.getTransaction().begin();
        em.merge(l); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro: "+e);
            e.printStackTrace();
    
        }
    }
}
    


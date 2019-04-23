/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import br.edu.ifsul.jpa.EntityManagerUtil;
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
public class TesteEditarPessoa {
    EntityManager em;
    
    public TesteEditarPessoa() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();//executar teste
    }
    
    @After
    public void tearDown() {
        em.close(); //encerrar conexão
    }
    
    @Test
    public void atualizar(){
        try{
        Pessoa p = em.find(Pessoa.class, 2);
        p.setNome("Pessoal");
        p.setTelefone("99672213");
        
        em.getTransaction().begin();
        em.merge(p); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
    
        }
    
    }
}

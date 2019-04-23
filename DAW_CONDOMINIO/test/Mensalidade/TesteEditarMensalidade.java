/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensalidade;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidade;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TesteEditarMensalidade {
    
 EntityManager em;
    
    public TesteEditarMensalidade() {
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
        Mensalidade m = em.find(Mensalidade.class, 17);
        m.setDataPagamento(Calendar.getInstance());
        m.setValor(680.50);
        m.setValorPagamento(680.50);
        m.setVencimento(Calendar.getInstance());
        
        m.setAluguel(em.find(Aluguel.class, 3)); //atualizar na table Aluguel
        
        em.getTransaction().begin();
        em.merge(m); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro: "+e);
            e.printStackTrace();
    
        }
    }
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensalidade;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidade;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daiah
 */
public class TestePersistirMensalidade {
    
  EntityManager em;

    public TestePersistirMensalidade() {
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
            Mensalidade m = new Mensalidade();
            m.setValor(900.75);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtV = sdf.parse("22/07/2011");
            Calendar vC = Calendar.getInstance();
            vC.setTime(dtV);
            m.setVencimento(vC);
                        
            SimpleDateFormat sdg = new SimpleDateFormat("dd/MM/yyyy");
            Date dtP = sdg.parse("22/08/2011");
            Calendar vP = Calendar.getInstance();
            vP.setTime(dtP);
            m.setDataPagamento(vP);
            //m.setDataPagamento(Calendar.getInstance());
            
            m.setValorPagamento(900.75);
            m.setAluguel(em.find(Aluguel.class, 2));
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aluguel;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Mensalidade;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;


/**
 *
 * @author daiah
 */
public class TestePersistirAluguel {
    
    EntityManager em;

    public TestePersistirAluguel() {
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
            Aluguel obj = new Aluguel();
            obj.setValor(600.00);
            
            SimpleDateFormat sdi = new SimpleDateFormat("dd/MM/yyyy");
            Date ini = sdi.parse("28/06/2018");
            Calendar c = Calendar.getInstance();
            c.setTime(ini);
            obj.setInicioContrato(c);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fim = sdf.parse("28/06/2020");
            Calendar f = Calendar.getInstance();
            f.setTime(fim);
            obj.setFimContrato(f);

            //obj.setFimContrato(Calendar.getInstance());
            
            obj.setDiaVencimento(30);
            obj.setLocatario(em.find(Locatario.class, 2));
            obj.setUc(em.find(UnidadeCondominial.class, 2));
            obj.addMensalidade(em.find(Mensalidade.class, 3));
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

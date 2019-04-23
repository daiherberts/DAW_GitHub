/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aluguel;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daiah
 */
public class TesteEditarAluguel {
    
    EntityManager em;
    
    public TesteEditarAluguel() {
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
        Aluguel a = em.find(Aluguel.class, 3);
        a.setValor(2000.00);
        
        SimpleDateFormat sdi = new SimpleDateFormat("dd/MM/yyyy");
            Date ini = sdi.parse("28/06/2018");
            Calendar c = Calendar.getInstance();
            c.setTime(ini);
            a.setInicioContrato(c);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fim = sdf.parse("28/06/2020");
            Calendar f = Calendar.getInstance();
            f.setTime(fim);
            a.setFimContrato(f);
            a.setDiaVencimento(10);

        em.getTransaction().begin();
        em.merge(a); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro: "+e);
            e.printStackTrace();
        }
    }
}
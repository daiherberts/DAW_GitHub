/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author daiah
 */
@Entity
@Table (name = "unidade_condominial")
public class UnidadeCondominial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_un_condominial", sequenceName = "seq_un_condominial_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_un_condominial", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O número não pode ser nulo")
    @NotBlank(message = "O número não pode ser em branco")
    @Length(max = 10, message = "O número não pode ter mais de {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false) 
    private String numero;
    
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", columnDefinition = "text") 
    private String descricao;
    
    @NotNull(message = "A área deve ser informada")
    @Column(name = "area", nullable = false, columnDefinition = ("decimal(10,2)"))
    private Double area;
    
    @NotNull(message = "O número do quarto deve ser informado")
    @Column(name = "numeroQuarto", nullable = false, columnDefinition = ("integer"))
    private Integer numeroQuarto;
    
    /*//relação Pessoa / UnidadeCondominal: cria nova tabela Proprietário
    @ManyToMany
    @JoinTable(name = "proprietario",
        joinColumns = 
            @JoinColumn(name = "unidade_condominial", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"unidade_condominial", "pessoa"})})
    private List<Pessoa> prorietario = new ArrayList<>();*/
    
    //CRIAR PROPRIETARIO
    @ManyToMany
    @JoinTable(name="proprietario",
            joinColumns = 
                @JoinColumn(name = "unidade_condominial", referencedColumnName = "id", nullable = false),
             inverseJoinColumns =       
                @JoinColumn(name="pessoa", referencedColumnName = "id", nullable = false)
            )
    private Set<Pessoa> listaProprietario = new HashSet<>();
    
    //mapeamento relação Condominio / Unidade
    @ManyToOne
    @NotNull(message = "O condominio deve ser informado")
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_unidadeCondominial_condominio")
    private Condominio condominio;
    
    public UnidadeCondominial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Set<Pessoa> getListaProprietario() {
        return listaProprietario;
    }

    public void setListaProprietario(Set<Pessoa> listaProprietario) {
        this.listaProprietario = listaProprietario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    @Override
    public String toString() {
        return "UnidadeCondominial{" + "id=" + id + ", descricao=" + descricao + ", numeroQuarto=" + numeroQuarto+'}';
    }
    
    public void adicionarProprietario(Pessoa p){
        listaProprietario.add(p);
    }
    
    
}

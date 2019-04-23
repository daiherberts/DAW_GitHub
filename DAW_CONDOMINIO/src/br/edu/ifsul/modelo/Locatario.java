/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author daiah
 */
@Entity
@Table(name = "locatario") //criar tabela locatário no BD
public class Locatario extends Pessoa implements Serializable{ 
    @NotNull(message = "A renda deve ser informada")
    @Column(name = "renda", nullable = false, columnDefinition = ("decimal(10,2)"))
    private Double renda;
    
    @NotNull(message = "O local de trabalho não pode ser nulo")
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @NotBlank(message = "O local de trabalho não pode ser em branco")
    @Column(name = "localTrabalho", nullable = false, length = 50) 
    private String localTrabalho;
    
    @NotNull(message = "O telefone não pode ser nulo")
    @Length(max = 16, message = "O telefone não pode ter mais que {max} caracteres")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Column(name = "telefoneTrabalho", nullable = false, length = 16) 
    private String telefoneTrabalho;

    public Locatario() {
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    
}
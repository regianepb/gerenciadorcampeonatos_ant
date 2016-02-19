package br.com.gerenciadorcampeonatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name = "POSICOES")
public class Posicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;    
     
    @NotNull 
    @Column(name="NOME",length=100)
    private String nome;
    
    
    
    /*
    @NotNull
    @Column(name="MODALIDADE",length=20,nullable=false)
    private String modalidade;
    
    @Enumerated(EnumType.STRING)
    private String modalidade1; */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
    
    
}

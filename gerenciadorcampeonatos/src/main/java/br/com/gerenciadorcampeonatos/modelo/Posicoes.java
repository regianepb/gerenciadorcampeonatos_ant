package br.com.gerenciadorcampeonatos.modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;


@Entity(name = "POSICOES")
public class Posicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;    
     
    @NotNull 
    @Column(name="DESCRICAO",length=100)
    private String descricao;
    
    @ManyToMany  
    @JoinColumn(name = "MODALIDADES_ID")
    private List<Modalidades> modalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Modalidades> getModalidade() {
        return modalidade;
    }

    public void setModalidade(List<Modalidades> modalidade) {
        this.modalidade = modalidade;
    }

   


  

  
    
    
}

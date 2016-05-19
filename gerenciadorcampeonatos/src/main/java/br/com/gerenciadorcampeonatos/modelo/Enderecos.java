package br.com.gerenciadorcampeonatos.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ENDERECOS")
public class Enderecos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name="CEP",length=8)
    private String cep;
    
    @Column(name="LOGRADOURO",length=100)
    private String logradouro;
    
    @Column(name="NUMERO",length=5)
    private String numero;
    
    @Column(name="COMPLEMENTO",length=200)
    private String complemento;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BAIRROS_ID")
    private Bairros bairros;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairros getBairro() {
        return bairros;
    }

    public void setBairro(Bairros bairro) {
        this.bairros = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    
}

package br.com.gerenciadorcampeonatos.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ENDERECO")
public class Enderecos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name="CEP",length=8)
    private String cep;
    
    @ManyToOne
    @JoinColumn(name = "BAIRRO_ID")
    private Bairros bairro;
  
    @Column(name="LOGRADOURO",length=100)
    private String logradouro;
    
    @Column(name="NUMERO",length=5)
    private String numero;
    
    @Column(name="COMPLEMENTO",length=100)
    private String complemento;
     
}

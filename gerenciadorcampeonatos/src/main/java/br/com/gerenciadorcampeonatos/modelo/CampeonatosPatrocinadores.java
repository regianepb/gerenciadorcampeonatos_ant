package br.com.gerenciadorcampeonatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "CAMPEONATOS_PATROCINADORES")
public class CampeonatosPatrocinadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
        
    @ManyToOne
    @JoinColumn(name = "PATROCINADORES_ID")
    private Patrocinadores patrocinador;
    
    @Column(name="VALOR")
    private double valor;

    @Column(name="OBSERVACAO",length=500)
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patrocinadores getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinadores patrocinador) {
        this.patrocinador = patrocinador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

  
    
    
}

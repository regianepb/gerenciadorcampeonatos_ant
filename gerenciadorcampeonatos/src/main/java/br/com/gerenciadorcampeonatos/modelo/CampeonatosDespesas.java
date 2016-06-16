package br.com.gerenciadorcampeonatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "CAMPEONATOS_DESPESAS")
public class CampeonatosDespesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
        
    @ManyToOne
    @JoinColumn(name = "DESPESAS_ID")
    private Despesas despesa;
    
    @Column(name="QUANTIDADE")
    private Long quantidade;
    
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

    public Despesas getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesas despesa) {
        this.despesa = despesa;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
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

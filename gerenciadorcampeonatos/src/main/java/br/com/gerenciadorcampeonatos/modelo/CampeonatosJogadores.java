package br.com.gerenciadorcampeonatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "CAMPEONATOS_JOGADORES")
public class CampeonatosJogadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
        
    @ManyToOne
    @JoinColumn(name = "JOGADOR_ID")
    private Jogadores jogador;
    
    @Column(name="VALOR")
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogadores getJogador() {
        return jogador;
    }

    public void setJogador(Jogadores jogador) {
        this.jogador = jogador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
  
    
    
}

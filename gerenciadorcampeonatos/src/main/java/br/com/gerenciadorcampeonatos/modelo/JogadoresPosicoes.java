package br.com.gerenciadorcampeonatos.modelo;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "JOGADOR_POSICAO")
public class JogadoresPosicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "JOGADOR_ID", nullable = false)
    private Jogadores jogador;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "POSICAO_ID", nullable = false)
    private Posicoes posicao;

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

    public Posicoes getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicoes posicao) {
        this.posicao = posicao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JogadoresPosicoes other = (JogadoresPosicoes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
              
}

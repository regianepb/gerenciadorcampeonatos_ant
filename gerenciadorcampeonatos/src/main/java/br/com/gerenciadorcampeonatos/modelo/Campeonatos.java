package br.com.gerenciadorcampeonatos.modelo;

import br.com.gerenciadorcampeonatos.util.LocalDateAttributeConverter;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "CAMPEONATOS")
public class Campeonatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name="NOME",length=200)
    private String nome;
    
    @Column(name="DATAINICIAL")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataInicial;
    
    @Column(name="DATAFINAL")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataFinal;
    
    @NotNull
    @Column(name="DIAJOGOS",length=100)
    private String diaJogos;
    
    @NotNull
    @Column(name="NOMETIME",length=200)
    private String nomeTime;
    
    @NotNull
    @Column(name="QTDJOGOS")
    private Long qtdJogos;
    
    @NotNull
    @Column(name="OBSERVACAO",length=500)
    private String observacao;
        
    @ManyToOne
    @JoinColumn(name = "MUNICIPIOS_ID")
    private Municipios municipio;

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

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDiaJogos() {
        return diaJogos;
    }

    public void setDiaJogos(String diaJogos) {
        this.diaJogos = diaJogos;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public Long getQtdJogos() {
        return qtdJogos;
    }

    public void setQtdJogos(Long qtdJogos) {
        this.qtdJogos = qtdJogos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Municipios getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }
        
  
}

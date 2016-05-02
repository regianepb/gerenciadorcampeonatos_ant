package br.com.gerenciadorcampeonatos.modelo;

import br.com.gerenciadorcampeonatos.util.LocalDateAttributeConverter;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "JOGADORES")
public class Jogadores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name="NOME",length=100,unique=true)
    private String nome;    
    
    @Column(name="APELIDO",length=50)
    private String apelido;
    
    @Column(name="DATANASCIMENTO")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataNascimento;
        
    @Column(name="RG",length=10)
    private String rg;
    
    @Column(name="DDD_TELEFONE",length=2)
    private String dddTelefone;
    
    @Column(name="TELEFONE",length=10)
    private String telefone;
    
    @Column(name="DDD_CELULAR",length=2)
    private String dddCelular;
    
    @NotNull
    @Column(name="CELULAR",length=10)
    private String celular;   
    
    @Column(name="EMAIL",length=50)
    private String email;
    
    @Column(name="FACEBOOK",length=50)
    private String facebook;
    
    @Column(name="FOTO")
    private Blob foto;
    
    @Column(name="DATAINCLUSAO")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataInclusao;

    @ManyToOne
    @JoinColumn(name = "TIMES_ID")
    private Times times;
    
    @OneToOne
    @JoinColumn(name = "ENDERECOS_ID")
    private Enderecos endereco;

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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public Enderecos getEndereco() {
        return endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    } 
  
    
}


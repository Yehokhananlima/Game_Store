package lojagames.br.Web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_produto")
	public class Produto {

	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull
    @Size(min = 2, max = 100, message = "Numero de  caracteres incorreto!")
    private String nome;
    
    @NotNull
    @Digits(integer = 5, fraction = 2, message = "Apenas milhares e  2 casas após o ponto") 
    private double preco;
    
    @ManyToOne
    @JsonIgnoreProperties("tb_produtos")
    private Categoria categoria;

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

	public double getPreco() {
	return preco;
	}

	public void setPreco(double preco) {
	this.preco = preco;
	}
    
    
    
	
}

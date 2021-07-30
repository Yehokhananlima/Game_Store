package lojagames.br.Web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size( min = 1, max = 50, message = "numero de caracteres excede a 50 caracteres")
    private String descricao;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produto;
    
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
}


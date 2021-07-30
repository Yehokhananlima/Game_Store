package lojagames.br.Web.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lojagames.br.Web.model.Categoria;
import lojagames.br.Web.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository repository;
        
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @GetMapping("/{id_categoria}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id_categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id_categoria).get());
    }
    
    @GetMapping("/descricao/{descricao_categoria}")
    public ResponseEntity<List<Categoria>> findByDescricao(@PathVariable String descricao_categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByDescricaoContainingIgnoreCase(descricao_categoria));
    }
    
    @PostMapping("/criar")
    public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria categoria){
        return ResponseEntity.status(200).body(repository.save(categoria));
    }
    
    @PutMapping("/atualizar")
    public ResponseEntity<Categoria> updateCategoria (@Valid @RequestBody Categoria categoria){
        return ResponseEntity.status(200).body(repository.save(categoria));
    }
    
    @DeleteMapping("/deletar/{id_categoria}")
    public ResponseEntity<String> deleteById (@PathVariable Long id_categoria ) {

        Optional<Categoria> categoriaExistente = repository.findById(id_categoria);
        
        if (categoriaExistente.isPresent()) {
            repository.deleteById(id_categoria);
            return ResponseEntity.status(200).body("Categoria Deletada");
        } else {
            return ResponseEntity.status(200).body("Categoria não encontrada");
        }
    }
}





/*package lojagames.br.Web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lojagames.br.Web.repository.CategoriaRepository;
import lojagames.br.Web.model.Categoria;


@RestController
@RequestMapping ("/loja")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;


	@GetMapping
	public ResponseEntity<List<Categoria>>GetAll(){
	return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Categoria>GetById(@PathVariable(value = "id")Long id){
	return ResponseEntity.status(200).body(repository.findById(id).get());
	}
	@GetMapping("/terror/{terror}")
	public ResponseEntity<List<Categoria>>GetByTerror(@PathVariable String terror){
	return ResponseEntity.ok(repository.findAllByTerrorContainingIgnoreCase(terror));
		
		}
	@PostMapping
	public ResponseEntity<Categoria>post(@RequestBody Categoria novacategoria){
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novacategoria));
	
	}
	@PutMapping
	public ResponseEntity<Categoria>put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/id")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
		
		
		
}*/


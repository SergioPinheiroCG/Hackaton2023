package TeamDoMar.Hackaton202310.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TeamDoMar.Hackaton202310.model.Usuario;
import TeamDoMar.Hackaton202310.service.UsuarioService;

@RestController
@RequestMapping("/swagger")
public class PixController {
	@Autowired
	private UsuarioService clienteService;

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario cliente) {
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
}

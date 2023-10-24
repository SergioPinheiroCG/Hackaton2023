package TeamDoMar.Hackaton202310.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TeamDoMar.Hackaton202310.model.Usuario;
//import TeamDoMar.Hackaton202310.repository.ContaRepository;
import TeamDoMar.Hackaton202310.repository.UsuarioRepository;

@Component
public class UsuarioService {
	@Autowired
	private UsuarioRepository userRepository;
//	@Autowired
//	private ContaRepository contaRepository;
	
	public Iterable<Usuario> buscarTodos(){
		return userRepository.findAll();
	}

	public Usuario buscarPorId(Integer id) {
		return userRepository.findById(id).get();
	}

	public Usuario inserir(Usuario user) {
		return userRepository.save(user);
	}

	public void deletar(Integer id) {
		userRepository.deleteById(id);
	}
}
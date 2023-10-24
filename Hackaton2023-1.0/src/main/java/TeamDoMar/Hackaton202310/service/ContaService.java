package TeamDoMar.Hackaton202310.service;
import org.springframework.beans.factory.annotation.Autowired;

import TeamDoMar.Hackaton202310.model.Usuario;
//import TeamDoMar.Hackaton202310.repository.ContaRepository;
import TeamDoMar.Hackaton202310.repository.UsuarioRepository;

public class ContaService {
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
//	private ContaRepository repository;
	
	// 1000 / 400 / 900
	public String transferencia(Usuario p1, Usuario p2, Double dinheiroTransferido) {
		Double saldoDoP1 = p1.getPix().getSaldo();
		Double saldoDoP2 = p2.getPix().getSaldo();
		if(saldoDoP1 >= dinheiroTransferido) {
			p1.getPix().setSaldo(saldoDoP1 - dinheiroTransferido);
			p2.getPix().setSaldo(saldoDoP2 + dinheiroTransferido);
			atualizarSaldo(p1.getId());
			atualizarSaldo(p2.getId());
			return "Transferência concluída!";
		}
		return "Saldo Insuficiente!";
	}
	public void atualizarSaldo(Integer id) {
		Usuario usuario = userRepository.findById(id).get();
		userRepository.save(usuario);
		
	}
	
}
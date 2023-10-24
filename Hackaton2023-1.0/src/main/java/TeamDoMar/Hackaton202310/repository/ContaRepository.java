package TeamDoMar.Hackaton202310.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import TeamDoMar.Hackaton202310.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
}

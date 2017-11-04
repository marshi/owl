package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.TicketNode;
import marshi.owl.domain.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TicketGraphRepository {

	private final TicketGraphRawRepository rawRepository;

	@Autowired
	public TicketGraphRepository(TicketGraphRawRepository rawRepository) {
		this.rawRepository = rawRepository;
	}

	public Optional<Ticket> findById(Long id, int depth) {
		Optional<TicketNode> node = rawRepository.findById(id, depth);
		return node.flatMap(n -> Optional.of(convert(n)));
	}

	public void deleteById(Long id) {
		rawRepository.deleteById(id);
	}

	private Ticket convert(TicketNode n) {
		return new Ticket(
				n.getId(),
				null,
				null,
				null,
				null,
				null
		);
	}

}

package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.TicketNode;
import marshi.owl.domain.entity.Ticket;
import marshi.owl.domain.repository.TicketGraphRepositoryInterface;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TicketGraphRepository implements TicketGraphRepositoryInterface {

	private final TicketGraphRawRepository rawRepository;

	@Autowired
	public TicketGraphRepository(TicketGraphRawRepository rawRepository) {
		this.rawRepository = rawRepository;
	}

	@Override
	public Optional<Ticket> findById(long id, int depth) {
		Optional<TicketNode> node = rawRepository.findById(id, depth);
		return node.flatMap(n -> Optional.of(convert(n)));
	}

	@Override
	public void deleteById(long id) {
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

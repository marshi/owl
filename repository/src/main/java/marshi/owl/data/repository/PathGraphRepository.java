package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.Path;
import marshi.owl.domain.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PathGraphRepository {

	private final PathGraphRawRepository rawRepository;

	@Autowired
	public PathGraphRepository(PathGraphRawRepository rawRepository) {
		this.rawRepository = rawRepository;
	}

	public Path save(Ticket prev, Ticket next) {
		return rawRepository.save(Path.convertFrom(prev, next));
	}

}

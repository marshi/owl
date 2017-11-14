package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.PathData;
import marshi.owl.domain.entity.Path;
import marshi.owl.domain.entity.Ticket;
import marshi.owl.domain.repository.PathGraphRepositoryInterface;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PathGraphRepository implements PathGraphRepositoryInterface {

	private final PathGraphRawRepository rawRepository;

	@Autowired
	public PathGraphRepository(PathGraphRawRepository rawRepository) {
		this.rawRepository = rawRepository;
	}

	@NotNull
	@Override
	public Path save(@NotNull Ticket prev, @NotNull Ticket next) {
		PathData pathData = rawRepository.save(PathData.convertFrom(prev, next));
		return pathData.convert();
	}

}

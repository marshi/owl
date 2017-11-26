package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.PathData;
import marshi.owl.domain.entity.Path;
import marshi.owl.domain.entity.Ticket;
import marshi.owl.domain.repository.PathGraphRepositoryInterface;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PathGraphRepository implements PathGraphRepositoryInterface {

	private final PathGraphRawRepository rawRepository;

	@Autowired
	public PathGraphRepository(PathGraphRawRepository rawRepository) {
		this.rawRepository = rawRepository;
	}

	@NotNull
	@Override
	public Path save(long projectId, @NotNull Ticket prev, @NotNull Ticket next) {
		PathData pathData = rawRepository.save(PathData.convertFrom(projectId, prev, next));
		return pathData.convert();
	}

	@NotNull
	@Override
	public Optional<Path> findBy(long prevTicketId, long nextTicketId) {
		PathData pathData = rawRepository.findByTicketIds(prevTicketId, nextTicketId);
		return Optional.ofNullable(pathData).map(PathData::convert);
	}

	@Override
	public List<Path> list(long projectId) {
		List<PathData> pathList = rawRepository.findByProjectId(projectId);
		return pathList.stream()
				.map(PathData::convert)
				.collect(Collectors.toList());
	}
}

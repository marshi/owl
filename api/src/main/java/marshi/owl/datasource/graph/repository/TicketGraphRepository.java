package marshi.owl.datasource.graph.repository;

import marshi.owl.datasource.graph.entity.TicketNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

/**
 * Created by a13178 on 2017/04/18.
 */
public interface TicketGraphRepository extends Neo4jRepository<TicketNode, Long> {

	@Override
	Optional<TicketNode> findById(Long aLong, int depth);

}

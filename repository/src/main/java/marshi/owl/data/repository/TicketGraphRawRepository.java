package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.TicketNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

/**
 * Created by a13178 on 2017/04/18.
 */
public interface TicketGraphRawRepository extends Neo4jRepository<TicketNode, Long> {

}

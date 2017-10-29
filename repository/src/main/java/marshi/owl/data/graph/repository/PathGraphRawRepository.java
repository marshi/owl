package marshi.owl.data.graph.repository;

import marshi.owl.data.graph.entity.Path;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by a13178 on 2017/04/21.
 */
public interface PathGraphRawRepository extends Neo4jRepository<Path, Long> {

}

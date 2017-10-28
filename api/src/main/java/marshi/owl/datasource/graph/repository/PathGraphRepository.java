package marshi.owl.datasource.graph.repository;

import marshi.owl.datasource.graph.entity.Path;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by a13178 on 2017/04/21.
 */
public interface PathGraphRepository extends Neo4jRepository<Path, Long> {

}

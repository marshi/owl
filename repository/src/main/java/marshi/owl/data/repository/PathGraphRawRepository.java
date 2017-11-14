package marshi.owl.data.repository;

import marshi.owl.data.graph.entity.PathData;
import marshi.owl.data.graph.entity.TicketNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by a13178 on 2017/04/21.
 */
public interface PathGraphRawRepository extends Neo4jRepository<PathData, Long> {

	@Query("MATCH (t1:" + TicketNode.ENTITY_NAME + ")-[path:path]->(t2:"+TicketNode.ENTITY_NAME+") " +
			"where id(t1)={id1} and id(t2)={id2} return path limit 1")
	PathData findByTicketIds(
			@Param("id1") long prevTicketId,
			@Param("id2") long nextTicketId
	);

}

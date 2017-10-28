package marshi.owl.datasource.graph.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import marshi.owl.datasource.graph.entity.TicketNode;

/**
 * Created by a13178 on 2017/04/18.
 */
public interface TicketGraphRepository extends GraphRepository<TicketNode>{

    @Override
    TicketNode findOne(Long id);

}

package marshi.owl.datasource.graph.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import marshi.owl.datasource.graph.entity.Ticket;

/**
 * Created by a13178 on 2017/04/18.
 */
public interface TicketGraphRepository extends GraphRepository<Ticket>{

    @Override
    Ticket findOne(Long id);

}

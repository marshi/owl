package marshi.owl.datasource.graph.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by a13178 on 2017/04/21.
 */
@RelationshipEntity(type = "path")
public class Path {

    @GraphId
    private Long id;

    @StartNode
    private Ticket prevTicket;

    @EndNode
    private Ticket nextTicket;

    public Path(Ticket prevTicket, Ticket nextTicket) {
        this.prevTicket = prevTicket;
        this.nextTicket = nextTicket;
    }

    public Ticket getPrevTicket() {
        return prevTicket;
    }

    public Ticket getNextTicket() {
        return nextTicket;
    }

}

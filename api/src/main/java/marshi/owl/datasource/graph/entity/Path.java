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
    private TicketNode prevTicketNode;

    @EndNode
    private TicketNode nextTicketNode;

    public Path(TicketNode prevTicketNode, TicketNode nextTicketNode) {
        this.prevTicketNode = prevTicketNode;
        this.nextTicketNode = nextTicketNode;
    }

    public TicketNode getPrevTicketNode() {
        return prevTicketNode;
    }

    public TicketNode getNextTicketNode() {
        return nextTicketNode;
    }

}

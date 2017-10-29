package marshi.owl.data.graph.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marshi.owl.domain.entity.Ticket;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * Created by a13178 on 2017/04/17.
 */
@NodeEntity
@Getter
@Setter
@NoArgsConstructor
public class TicketNode {

    @GraphId
    private Long id;

    @Relationship(type = "path")
    private Set<TicketNode> nextStepTicketNodes;

    public TicketNode(Long id, Set<TicketNode> nextStepTicketNodes) {
        this.id = id;
        this.nextStepTicketNodes = nextStepTicketNodes;
    }

    public Long getId() {
        return id;
    }

    public Set<TicketNode> getNextStepTicketNodes() {
        return nextStepTicketNodes;
    }

    public static TicketNode convertFrom(Ticket ticket) {
       return new TicketNode();
    }

}

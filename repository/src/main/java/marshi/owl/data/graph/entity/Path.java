package marshi.owl.data.graph.entity;

import marshi.owl.domain.entity.Ticket;
import marshi.owl.ttt.Test;
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
		new Test();
		this.prevTicketNode = prevTicketNode;
		this.nextTicketNode = nextTicketNode;
	}

	public TicketNode getPrevTicketNode() {
		return prevTicketNode;
	}

	public TicketNode getNextTicketNode() {
		return nextTicketNode;
	}

	public static Path convertFrom(Ticket prev, Ticket next) {
		return new Path(
				TicketNode.convertFrom(prev),
				TicketNode.convertFrom(next)
		);
	}

}

package marshi.owl.data.graph.entity;

import marshi.owl.domain.entity.Path;
import marshi.owl.domain.entity.Ticket;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by a13178 on 2017/04/21.
 */
@RelationshipEntity(type = "path")
public class PathData {

	@GraphId
	private Long id;

	@StartNode
	private TicketNode prevTicketNode;

	@EndNode
	private TicketNode nextTicketNode;

	public PathData(TicketNode prevTicketNode, TicketNode nextTicketNode) {
		this.prevTicketNode = prevTicketNode;
		this.nextTicketNode = nextTicketNode;
	}

	public TicketNode getPrevTicketNode() {
		return prevTicketNode;
	}

	public TicketNode getNextTicketNode() {
		return nextTicketNode;
	}

	public static PathData convertFrom(Ticket prev, Ticket next) {
		return new PathData(
				TicketNode.convertFrom(prev),
				TicketNode.convertFrom(next)
		);
	}

	public Path convert() {
		return new Path(
				this.id,
				this.prevTicketNode.convert(),
				this.nextTicketNode.convert()
		);
	}

}

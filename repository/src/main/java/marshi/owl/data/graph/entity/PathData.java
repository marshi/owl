package marshi.owl.data.graph.entity;

import lombok.NoArgsConstructor;
import marshi.owl.domain.entity.Path;
import marshi.owl.domain.entity.Ticket;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by a13178 on 2017/04/21.
 */
@NoArgsConstructor
@RelationshipEntity(type = "path")
public class PathData {

	@GraphId
	private Long id;

	private Long projectId;

	@StartNode
	private TicketNode prevTicketNode;

	@EndNode
	private TicketNode nextTicketNode;

	public PathData(Long projectId, TicketNode prevTicketNode, TicketNode nextTicketNode) {
		this.projectId = projectId;
		this.prevTicketNode = prevTicketNode;
		this.nextTicketNode = nextTicketNode;
	}

	public TicketNode getPrevTicketNode() {
		return prevTicketNode;
	}

	public TicketNode getNextTicketNode() {
		return nextTicketNode;
	}

	public Long getProjectId() {
		return projectId;
	}

	public static PathData convertFrom(Long projectId, Ticket prev, Ticket next) {
		return new PathData(
				projectId,
				TicketNode.convertFrom(prev),
				TicketNode.convertFrom(next)
		);
	}

	public Path convert() {
		return new Path(
				this.id,
				this.projectId,
				this.prevTicketNode.convert(),
				this.nextTicketNode.convert()
		);
	}

}

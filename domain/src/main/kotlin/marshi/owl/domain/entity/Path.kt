package marshi.owl.domain.entity

class Path(
    private val id: Long?,
    private val projectId: Long,
    private val prevTicket: Ticket,
    private val nextTicket: Ticket
)




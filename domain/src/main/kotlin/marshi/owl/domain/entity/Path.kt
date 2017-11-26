package marshi.owl.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Path(
    val id: Long?,
    val projectId: Long,
    val prevTicket: Ticket,
    val nextTicket: Ticket
)




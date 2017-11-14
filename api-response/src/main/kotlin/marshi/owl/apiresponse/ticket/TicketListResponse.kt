package marshi.owl.apiresponse.ticket

import marshi.owl.apiresponse.DataListResponse
import marshi.owl.domain.entity.Ticket

class TicketListResponse(val data: List<Ticket>, val summary: Void?)
    : DataListResponse<Ticket, Void>(data, summary) {

    constructor(): this(
        listOf(),
        null
    )

}

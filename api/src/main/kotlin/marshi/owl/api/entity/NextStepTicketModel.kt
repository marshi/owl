package marshi.owl.api.entity

import lombok.NoArgsConstructor
import lombok.Setter
import marshi.owl.domain.entity.Ticket

/**
 * Created by a13178 on 2017/04/21.
 */
@NoArgsConstructor
@Setter
class NextStepTicketModel(
    private var id: Long? = null
) {
    fun convert(): Ticket {
        return Ticket(this.id)
    }
}
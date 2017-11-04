package marshi.owl.api.entity

import lombok.NoArgsConstructor
import lombok.NonNull
import lombok.Setter
import javax.validation.constraints.NotNull

/**
 * Created by a13178 on 2017/04/21.
 */
@Setter
@NoArgsConstructor
class RequestPath(
        var prevTicketId: Long? = null,
        var nextTicketId: Long? = null
)
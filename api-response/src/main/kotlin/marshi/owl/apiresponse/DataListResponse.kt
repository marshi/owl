package marshi.owl.apiresponse

import lombok.NoArgsConstructor

@NoArgsConstructor
abstract class DataListResponse<D, S>(
        private val data: List<D>,
        private val summary: S?
)

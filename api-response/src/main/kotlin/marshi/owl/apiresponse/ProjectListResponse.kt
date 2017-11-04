package marshi.owl.apiresponse

import marshi.owl.domain.entity.Project

class ProjectListResponse(
    val data: List<Project>,
    val summary: Void?
) : DataListResponse<Project, Void>(data, summary) {

    constructor(): this(listOf(), null)

}

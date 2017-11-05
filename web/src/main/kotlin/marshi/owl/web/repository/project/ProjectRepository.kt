package marshi.owl.web.repository.project

import marshi.owl.apiresponse.project.ProjectListResponse
import marshi.owl.domain.entity.Project
import marshi.owl.web.repository.HttpApiTemplate
import org.springframework.stereotype.Repository

@Repository
class ProjectRepository(
    private val httpApiTemplate: HttpApiTemplate
) {

    fun list(): List<Project> {
        val entity = httpApiTemplate
            .resource("/projects")
            .get()
            .getEntity(ProjectListResponse::class.java)
        return entity.data
    }

}
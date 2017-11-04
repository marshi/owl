package marshi.owl.web.repository.project

import marshi.owl.domain.entity.Project
import marshi.owl.web.repository.HttpApiTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ProjectRepository(
    @Autowired private val httpApiTemplate: HttpApiTemplate
) {

    fun list(): List<Project> {
        return listOf(
            Project(1, "OWL"),
            Project(2, "BIRD")
        )
    }

}
package marshi.owl.data.repository;

import marshi.owl.data.rdb.entity.ProjectRecord;
import marshi.owl.data.rdb.entity.ProjectRecordExample;
import marshi.owl.data.rdb.mapper.ProjectRecordMapper;
import marshi.owl.domain.entity.Project;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProjectRepository {

	private ProjectRecordMapper projectMapper;

	ProjectRepository(@Autowired ProjectRecordMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public List<Project> list() {
		List<ProjectRecord> list =
				projectMapper.selectByExample(new ProjectRecordExample());
		return list.stream()
				.map(ProjectRepository::convertFrom)
				.collect(Collectors.toList());
	}

	public void create(@NotNull Project project) {
		projectMapper.insertSelective(convert(project));
	}

	private static Project convertFrom(ProjectRecord p) {
		return new Project(
				p.getId(),
				p.getName()
		);
	}

	private static ProjectRecord convert(Project p) {
		ProjectRecord project = new ProjectRecord();
		project.setId(p.getId());
		project.setName(p.getName());
		return project;
	}

}

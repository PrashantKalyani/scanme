package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}

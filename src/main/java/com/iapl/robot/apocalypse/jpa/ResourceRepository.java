package com.iapl.robot.apocalypse.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iapl.robot.apocalypse.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{
}

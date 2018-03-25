package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityInterface extends JpaRepository<Community, Integer> {
}

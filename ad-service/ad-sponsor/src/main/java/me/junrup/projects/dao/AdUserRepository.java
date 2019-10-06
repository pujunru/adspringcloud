package me.junrup.projects.dao;

import me.junrup.projects.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUserRepository extends JpaRepository<AdUser, Long> {
    /**
     * <h2> Find AdUser object by username</h2>
     */
    AdUser findByUsername(String username);
}

package com.roma_n_ibragim.store.repositories;

import com.roma_n_ibragim.store.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}

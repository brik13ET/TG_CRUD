package com.roma_n_ibragim.store.repositories;

import com.roma_n_ibragim.store.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    public List<Registration> findAllByDay(int day, int month);
}

package com.roma_n_ibragim.store.services;

import com.roma_n_ibragim.store.models.Registration;
import com.roma_n_ibragim.store.repositories.RegistrationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private  final  RegistrationRepo repo;

    public RegistrationService(RegistrationRepo repo) {
        this.repo = repo;
    }

    public List<Registration> findAllByDay(int day, int month){
        return repo.findAll().stream()
                .filter(x->x.getStartTime().getDay()==day
                        &&x.getStartTime().getMonth()==month).collect(Collectors.toList());
    }
}

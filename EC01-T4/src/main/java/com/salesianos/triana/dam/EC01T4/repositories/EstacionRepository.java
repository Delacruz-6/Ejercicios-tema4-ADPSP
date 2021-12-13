package com.salesianos.triana.dam.EC01T4.repositories;

import com.salesianos.triana.dam.EC01T4.models.EstacionDeServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface EstacionRepository extends JpaRepository<EstacionDeServicio, Long> {


}

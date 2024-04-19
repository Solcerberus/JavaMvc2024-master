package com.example.javamvc2024.repositories;

import com.example.javamvc2024.entities.ForecastEntity;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<ForecastEntity, Integer>{
}

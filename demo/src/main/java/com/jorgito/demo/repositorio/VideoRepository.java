package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long>{

    Video findById(long id);

}

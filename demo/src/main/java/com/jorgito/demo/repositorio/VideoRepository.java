package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.jorgito.demo.modelo.Video;

public interface VideoRepository extends CrudRepository<Video, Long>{

    Video findById(long id);

}

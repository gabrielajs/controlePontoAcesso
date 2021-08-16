package com.g2b.projeto.repository;

import com.g2b.projeto.model.TipoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDataRepository extends JpaRepository <TipoData, Long>{
}

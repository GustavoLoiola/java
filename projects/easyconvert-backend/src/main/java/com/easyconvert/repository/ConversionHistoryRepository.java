package com.easyconvert.repository;

import com.easyconvert.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {

    List<ConversionHistory> findByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<ConversionHistory> findByIdAndUserId(Long id, Long userId);
}
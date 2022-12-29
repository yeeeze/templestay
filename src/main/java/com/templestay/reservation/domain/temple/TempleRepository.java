package com.templestay.reservation.domain.temple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TempleRepository extends JpaRepository<Temple, Long> {
}

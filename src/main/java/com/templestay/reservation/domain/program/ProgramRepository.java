package com.templestay.reservation.domain.program;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

interface ProgramRepository extends JpaRepository<Program, BigInteger> {
}

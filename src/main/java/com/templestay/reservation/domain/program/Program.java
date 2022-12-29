package com.templestay.reservation.domain.program;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Entity
public class Program {

    @Id
    private BigInteger id;
    private Area area;
    private Kind kind;
    private Date startDate;
    private Date endDate;

    public Program() {
    }

    public Program(BigInteger id, Area area, Kind kind, Date startDate, Date endDate) {
        this.id = id;
        this.area = area;
        this.kind = kind;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

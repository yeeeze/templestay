package com.templestay.reservation.domain.program;

import com.templestay.reservation.domain.temple.Temple;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Getter
@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private BigInteger id;
    @Enumerated(EnumType.STRING)
    private Area area;
    @Enumerated(EnumType.STRING)
    private Kind kind;
    @Column(columnDefinition = "DATE")
    private Date startDate;     // year, month, date
    @Column(columnDefinition = "DATE")
    private Date endDate;

    @Column(name = "temple_id", insertable = false, updatable = false)
    private Long templeId;

    @ManyToOne
    @JoinColumn(name = "temple_id", referencedColumnName = "id")
    private Temple temple;

    public Program() {
    }

    public Program(BigInteger id, Area area, Kind kind, Date startDate, Date endDate, Temple tepleId) {
        this.id = id;
        this.area = area;
        this.kind = kind;
        this.startDate = startDate;
        this.endDate = endDate;
        this.temple = tepleId;
    }

    public void setTemple(Temple temple) {
        if (Objects.nonNull(this.temple)) {
            temple.getPrograms().remove(this);
        }
        this.temple = temple;
        temple.getPrograms().add(this);
    }
}

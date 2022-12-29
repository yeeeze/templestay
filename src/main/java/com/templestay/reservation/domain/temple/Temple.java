package com.templestay.reservation.domain.temple;

import com.templestay.reservation.domain.program.Program;
import lombok.Getter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Entity
@Table(name = "temple")
public class Temple {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    private Long pageTempleId;
    private String name;
    private String englishName;
    private String address;
    private String contacts;
    @OneToMany(mappedBy = "temple", cascade = CascadeType.ALL)
    private List<Program> programs;

    public Temple() {
    }

    public Temple(Long pageTempleId, String name, String englishName, String address, String contacts) {
        this.pageTempleId = pageTempleId;
        this.name = name;
        this.englishName = englishName;
        this.address = address;
        this.contacts = contacts;
    }

    public void addProgram(Program program) {
        program.setTemple(this);
    }

    public List<String> getContacts(String contacts) {
        String[] contactsSplit = contacts.split(",");
        return Arrays.asList(contactsSplit);
    }
}

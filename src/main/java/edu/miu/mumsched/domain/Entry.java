package edu.miu.mumsched.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import edu.miu.mumsched.domain.Block;
import org.springframework.format.annotation.DateTimeFormat;

@javax.persistence.Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryId;
    private String entryName;
    private int FPPName;
    private  int MPPName;

    @DateTimeFormat(pattern = "MM/dd/YYYY")
    private Date startDate;

    @DateTimeFormat(pattern = "MM/dd/YYYY")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entry")
    private Set <Block> blockSet = new HashSet<>();
    public void addBlock(Block block){
        blockSet.add(block);
        block.setEntry(this);
    }

}

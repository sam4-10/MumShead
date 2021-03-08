package edu.miu.mumsched.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blockId;
    private int FPPName;
    private  int MPPName;

    @DateTimeFormat(pattern = "MM-dd-YYYY")
    private Date startDate;

    @DateTimeFormat(pattern = "MM-dd-YYYY")
    private Date endDate;

    private String blockName;
    private String entryName;
    @JoinColumn(name = "entryId",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Entry entry;


}



package org.sid.orderservicequery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.enums.CommandStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Command {
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    private String city;
    private String Street;
    @Enumerated(EnumType.STRING)
    private CommandStatus commandStatus;
}

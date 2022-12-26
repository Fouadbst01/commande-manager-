package org.sid.orderservicequery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class CommandLine {
    @Id
    private String id;
    @OneToOne
    private Product product;

    private int OrderedQTE;
}

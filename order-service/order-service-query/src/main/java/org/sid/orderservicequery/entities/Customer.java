package org.sid.orderservicequery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String city;
    private String street;
    @OneToMany(mappedBy = "customer")
    List<Command> commandList;
}

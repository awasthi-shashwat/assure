package com.constructWeek3.assure.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOfClaim;
    private Date dateOfTreatment;
    private Float amountToClaim;
    @OneToMany
    private List<Document> documents;
    private String membershipId;
    @ManyToOne
    private PolicyBookings policyBookings;

    public void addDocuments(Document document) {
        this.documents.add(document);
    }
}

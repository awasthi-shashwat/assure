package com.constructWeek3.assure.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JoinColumn(name="claim_id")
    private List<Document> documents = new ArrayList<>();

    @ManyToOne
    private Members member;

    @ManyToOne
    private PolicyBookings policyBookings;

    public void addDocuments(Document document) {
        this.documents.add(document);
    }
}

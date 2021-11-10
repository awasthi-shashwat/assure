package com.constructWeek3.assure.dto;

import com.constructWeek3.assure.entity.Document;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.entity.PolicyBookings;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaimDTO {
    private Long id;
    private Date dateOfClaim;
    private Date dateOfTreatment;
    private Float amountToClaim;

    private List<Document> documents = new ArrayList<>();

    private Members member;

    private PolicyBookings policyBookings;
}

package me.junrup.projects.entity.unit_limitation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit_interest")
public class AdUnitInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "interest_tag", nullable = false)
    private String interestTag;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    public AdUnitInterest(Long unitId, String interestTag) {
        this.unitId = unitId;
        this.interestTag = interestTag;

        this.createTime = new Date();
    }
}


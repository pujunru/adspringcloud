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
@Table(name = "ad_unit_location")
public class AdUnitLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "state", nullable = false)
    private String state;

    @Basic
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    public AdUnitLocation(Long unitId, String state, String city) {
        this.unitId = unitId;
        this.state = state;
        this.city = city;

        this.createTime = new Date();
    }
}


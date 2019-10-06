package me.junrup.projects.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "creativity_unit")
public class CreativityUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "creativity_id", nullable = false)
    private Long creativityId;

    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    public CreativityUnit(Long creativityId, Long unitId) {
        this.creativityId = creativityId;
        this.unitId = unitId;

        this.createTime = new Date();
    }
}

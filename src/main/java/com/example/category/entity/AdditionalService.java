package com.example.category.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@ToString
public class AdditionalService {

    @Id
    private int     serverId;

    /*
     * 3개의 부가서비스
     * 0일시 사용안함 값이 들어있을시 해당 날짜까지 사용(Date)
     */
    private int     useLoadBalancing;
    private int     useSlabAllocation;
    private Replica useReplica;

}

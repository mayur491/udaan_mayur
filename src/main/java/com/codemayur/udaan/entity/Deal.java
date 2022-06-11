package com.codemayur.udaan.entity;

/*
Deal
	deal_id Long
	item_id String
	deal_price Long
	total_number_of_items Long
	current_number_of_items Long
	seller_id Long
	status enum
	from_time Date
	to_time Date
 */


import com.codemayur.udaan.enums.DealStatus;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Builder
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long deal_id;

    private Long item_id;
    private Double deal_price;
    private Integer total_number_of_items;
    private Integer current_number_of_items;
    private Long seller_id;
    private DealStatus status;
    private Date from_time;
    private Date to_time;

}

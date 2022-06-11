package com.codemayur.udaan.entity.dto;

import com.codemayur.udaan.entity.Deal;
import com.codemayur.udaan.enums.DealStatus;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DealDto implements Serializable {

    public static Deal covertToDeal(DealDto dealDto) {
        Deal deal = new Deal();
        deal.setItem_id(dealDto.getItem_id());
        deal.setDeal_price(dealDto.getDeal_price());
        deal.setTotal_number_of_items(dealDto.getTotal_number_of_items());
        deal.setCurrent_number_of_items(dealDto.getCurrent_number_of_items());
        deal.setSeller_id(dealDto.getSeller_id());
        deal.setStatus(dealDto.getStatus());
        deal.setFrom_time(dealDto.getFrom_time());
        deal.setTo_time(dealDto.getTo_time());
        return deal;
    }

    private Long item_id;
    private Double deal_price;
    private Integer total_number_of_items;
    private Integer current_number_of_items;
    private Long seller_id;
    private DealStatus status;
    private Date from_time;
    private Date to_time;

}

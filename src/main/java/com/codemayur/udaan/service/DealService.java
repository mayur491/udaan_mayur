package com.codemayur.udaan.service;

import com.codemayur.udaan.dao.DealRepository;
import com.codemayur.udaan.entity.Deal;
import com.codemayur.udaan.entity.dto.DealDto;
import com.codemayur.udaan.enums.DealStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Slf4j
public class DealService {

    private final DealRepository dealRepository;

    @Autowired
    DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public Long createDeal(DealDto dealDto) {
        log.info("dealDto: " + dealDto);
        // convert dealDto to Deal
        Deal deal = DealDto.covertToDeal(dealDto);

        log.info("deal: " + deal);

        // save deal
        return saveDeal(deal);
    }

    @Transactional
    private Long saveDeal(Deal deal) {

        Deal newdeal = dealRepository.save(deal);

        log.info("newdeal: " + newdeal);

        log.info(String.valueOf(dealRepository.findAll()));

        return newdeal.getDeal_id();
    }

    public Long removeDeal(Long deal_id, Long sellerId) {
        // get deal
        Deal deal = dealRepository.getById(deal_id);

        // validate seller id
        if (!Objects.equals(deal.getSeller_id(), sellerId)) {
            // TODO: create custom exeption
            throw new IllegalStateException("You do not hve permissions to delete this deal");
        }

        // make inActive
        deal.setStatus(DealStatus.INACTIVE);

        // delete deal
        return saveDeal(deal);
    }

    public Long updateDeal(Long dealId, DealDto dealDto) {
        // get Deal
        Deal deal = dealRepository.getById(dealId);

        // update deal current number od items
        deal.setCurrent_number_of_items(deal.getCurrent_number_of_items() + dealDto.getTotal_number_of_items());

        // update deal total number od items
        deal.setTotal_number_of_items(deal.getTotal_number_of_items() + dealDto.getTotal_number_of_items());

        // update deal end time
        deal.setTo_time(dealDto.getTo_time());

        // update deal
        return saveDeal(deal);
    }

    @Transactional
    public Long claimDeal(Long deal_id, Long userId) {
        // get Deal
        Deal deal = dealRepository.getById(deal_id);

        // check if deal is active
        if (!DealStatus.ACTIVE.equals(deal.getStatus())) {
            // TODO: create custom exception
            throw new IllegalStateException("Deal is no longer Active");
        }

        // check if claim is within the time limit
        if (!DealStatus.ACTIVE.equals(deal.getStatus())) {
            // TODO: create custom exception
            throw new IllegalStateException("Deal is no longer Active");
        }

        // update the current number of items
        if (!DealStatus.ACTIVE.equals(deal.getStatus())) {
            // TODO: create custom exception
            throw new IllegalStateException("Deal is no longer Active");
        }



        // update deal
        return saveDeal(deal);
    }
}

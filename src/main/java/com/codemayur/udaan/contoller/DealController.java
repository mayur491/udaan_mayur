package com.codemayur.udaan.contoller;

import com.codemayur.udaan.entity.dto.DealDto;
import com.codemayur.udaan.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/deal")
public class DealController {

    private final DealService dealService;

    @Autowired
    DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping
    public ResponseEntity<Long> createDeal(@RequestBody DealDto dealDto) { // TODO add @Valid
        log.info("dealDto: " + dealDto);
        Long dealId;
        try {
            dealId = dealService.createDeal(dealDto);
        } catch (Exception e) {
            log.error(String.valueOf(e), e);
            return new ResponseEntity<>(0L, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("dealId: " + dealId);
        return new ResponseEntity<>(dealId, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Long> removeDeal(@RequestParam Long deal_id, Long sellerId) {
        Long dealId;
        try {

            // TODO: add checks if deal is present or seller id is invalid

            dealId = dealService.removeDeal(deal_id, sellerId);
        } catch (Exception e) {
            log.error(String.valueOf(e), e);
            return new ResponseEntity<>(0L, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dealId, HttpStatus.OK);
    }

    @PutMapping("{deal_id}")
    public ResponseEntity<Long> updateDeal(@RequestParam Long dealId, @RequestBody DealDto dealDto) { // TODO add @Valid
        Long responseDealId;
        try {

            // TODO: add checks if deal is present or seller id is invalid

            responseDealId = dealService.updateDeal(dealId, dealDto);
        } catch (Exception e) {
            log.error(String.valueOf(e), e);
            return new ResponseEntity<>(0L, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDealId, HttpStatus.OK);
    }

    @PostMapping("/claim_deal")
    public ResponseEntity<Long> claimDeal(@RequestParam Long deal_id, Long userId) {
        Long dealId;
        try {

            // TODO: add checks if deal is present or seller id is invalid
            // TODO: check status & time validity (from and to)
            // TODO: num of remaining items > 0
            // TODO: same user shouldn't be able to buy 2 same deals


            dealId = dealService.claimDeal(deal_id, userId);
        } catch (Exception e) {
            log.error(String.valueOf(e), e);
            return new ResponseEntity<>(0L, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dealId, HttpStatus.OK);
    }

}

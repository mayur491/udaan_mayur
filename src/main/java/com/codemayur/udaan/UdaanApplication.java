package com.codemayur.udaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Problem Statement

You happen to be a budding entrepreneur and you have come up with an idea to build an e-commerce giant like Amazon,
Flipkart, Walmart, etc. As part of this ambition, you want to build a platform to duplicate the concept of Limited Time Deals.

Limited Time Deals

A limited-time deal implies that a seller will put up an item on sale for a limited time period, say, 2 hours,
and will keep a maximum limit on the number of items that would be sold as part of that deal.
Users cannot buy the deal if the deal time is over
Users cannot buy if the maximum allowed deal has already been bought by other users.
One user cannot buy more than one item as part of the deal.

The task is to create APIs to enable the following operations:
Create a deal with the price and number of items to be sold as part of the deal
End a deal
Update a deal to increase the number of items or end time
Claim a deal


Guidelines:
Document and communicate your assumptions in README.
Create a working solution with production-quality code.
Use an external database like Postgres/MySQL or any NoSQL database
Define and Create APIs to support the operations mentioned above
Write a few unit tests for the most important code
What are we looking for?
Your approach to the solution
How you write code in terms of readability and maintainability
Usage of best practices
Testing skills

Out of scope: Handling at large scale


------------------------------


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

UserDeal
	user_id Long
	deal_id Long FK

 */

@SpringBootApplication
public class UdaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdaanApplication.class, args);
	}

}

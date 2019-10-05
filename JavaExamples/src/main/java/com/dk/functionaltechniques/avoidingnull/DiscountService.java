package com.dk.functionaltechniques.avoidingnull;

import java.math.BigDecimal;
import java.util.Optional;

public class DiscountService {
    public BigDecimal calculateDiscount(Order order, Customer customer) {
        /*BigDecimal discount = getDiscountPercentage(customer.getRewardPoints());
        if (discount != null) {
            return order.getTotal().multiply(discount);
        } else {
            return BigDecimal.ZERO;
        }*/
    	return customer.getRewardPoints() //Optional<RewardPoints>
    			.flatMap(rp -> getDiscountPercentage(rp)) //Optional<Bigdecimal>
	    		.map(discount -> order.getTotal().multiply(discount)) //Optional<Bigdecimal>
	    		.orElse(BigDecimal.ZERO);
    }

    //we should not make a method to take optional instead don't call the method if no rewards
    //Don't use Optional as method arguments
    private Optional<BigDecimal> getDiscountPercentage(RewardPoints rewardPoints) {
            if (rewardPoints.getPoints() >= 100) {
                return Optional.of(new BigDecimal("10.0"));
            }
            else if (rewardPoints.getPoints() >= 50) {
                return Optional.of(new BigDecimal("5.0"));
            }
        return Optional.empty();
    }
}

class Order {
    public BigDecimal getTotal() {
        return BigDecimal.TEN;
    }
}

class RewardPoints {
    public final Integer points;

    public RewardPoints(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public RewardPoints combine(RewardPoints rewardPoints) {
        return new RewardPoints(this.points + rewardPoints.points);
    }

    @Override
    public String toString() {
        return "RewardPoints{" +
                "points=" + points +
                '}';
    }
}

class Customer {
    private RewardPoints rewardPoints;

    public void setRewardPoints(RewardPoints rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Optional<RewardPoints> getRewardPoints() {
        return Optional.ofNullable(rewardPoints);
    }
}


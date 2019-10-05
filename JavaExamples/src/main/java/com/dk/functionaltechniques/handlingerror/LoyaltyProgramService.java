package com.dk.functionaltechniques.handlingerror;

public class LoyaltyProgramService {
    private ProductRepository productRepository = new ProductRepository();
    private LoyaltyProgramRepository lpRepository = new LoyaltyProgramRepository();

    public void updateGiftReward(GiftRewardLoyaltyProgram newLoyaltyProgram){
        if(!isNumberOfPointsValid(newLoyaltyProgram)) {
            throw new RuntimeException("Invalid points");
        }
        if(isProductValid(newLoyaltyProgram)) {
            throw new RuntimeException("Invalid product");
        }
        GiftRewardLoyaltyProgram lp = lpRepository.getGiftRewardLoyaltyProgram();
        if(lp == null) {
            throw new RuntimeException("The loyalty program was not found");
        }

        lp.setNeededPoints(newLoyaltyProgram.getNeededPoints());
        lp.setProductId(newLoyaltyProgram.getProductId());

        try {
            lpRepository.save(lp);
        } catch(Exception e) {
            throw new RuntimeException("Error when saving to the database");
        }
    }

    private boolean isNumberOfPointsValid(GiftRewardLoyaltyProgram lp) {
        boolean valid = false;

        if(lp.getNeededPoints() != null || lp.getNeededPoints() > 0) {
            valid = true;
        }

        return valid;
    }

    private boolean isProductValid(GiftRewardLoyaltyProgram lp) {
        return productRepository.getProductById(lp.getProductId()) != null;
    }
}

class ProductRepository {
    public Product getProductById(Long id) {
        // Get product from the database
        return new Product(id);
    }
}

class LoyaltyProgramRepository {
    public GiftRewardLoyaltyProgram getGiftRewardLoyaltyProgram() {
        // Get loyalty program from the database
        return new GiftRewardLoyaltyProgram(1L, 100);
    }

    public GiftRewardLoyaltyProgram save(GiftRewardLoyaltyProgram lp) {
        // Save loyalty program to the database
        return lp;
    }
}

class GiftRewardLoyaltyProgram {

    private Long productId;
    private Integer neededPoints;

    public GiftRewardLoyaltyProgram() {}

    public GiftRewardLoyaltyProgram(Long productId, Integer neededPoints) {
        this.productId = productId;
        this.neededPoints = neededPoints;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNeededPoints() {
        return neededPoints;
    }

    public void setNeededPoints(Integer neededPoints) {
        this.neededPoints = neededPoints;
    }

    @Override
    public String toString() {
        return "GiftRewardLoyaltyProgram{" +
                "productId=" + productId +
                ", neededPoints=" + neededPoints +
                '}';
    }
}

class Product {
    private Long productId;

    public Product() {}

    public Product(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
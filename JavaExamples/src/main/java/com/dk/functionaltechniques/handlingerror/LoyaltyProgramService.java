package com.dk.functionaltechniques.handlingerror;

public class LoyaltyProgramService {
    private ProductRepository productRepository = new ProductRepository();
    private LoyaltyProgramRepository lpRepository = new LoyaltyProgramRepository();

    /**
     * The function is persisting the GiftRewardLoyaltyProgram into the database after validating 
     * points and valid product and also with some database error checking
     * 
     * Updates performed in the method for adopting functional way of error handling is as below - 
     * 1) Functional programming best practices is never to use void instead it should return 
     * a value for given input so we will change the return type. Since it is updating GiftRewardLoyaltyProgram,
     * we will return the updated GiftRewardLoyaltyProgram instead of void
     * 
     * 
     * @param newLoyaltyProgram
     */
    public Result<GiftRewardLoyaltyProgram> updateGiftReward(GiftRewardLoyaltyProgram newLoyaltyProgram){
        /*if(!isNumberOfPointsValid(newLoyaltyProgram)) {
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
        }*/
    	return Result.ofNullable(newLoyaltyProgram)
    				 .flatMap(this::isNumberOfPointsValid)
    				 .flatMap(this::isProductValid) //till this step validation finishes
    				 .flatMap(lp -> Result.of(lpRepository.getGiftRewardLoyaltyProgram()))
    				 .map(lp -> updateLoyaltyProgram(lp, newLoyaltyProgram)) //returns plain GiftRewardLoyaltyProgram 
    				 .map(lpRepository::save); //returns plain GiftRewardLoyaltyProgram instead of Result hence using map
    }
    
    public static void main(String args[]) {
        LoyaltyProgramService service = new LoyaltyProgramService();

        // Null
        System.out.println(service.updateGiftReward(null));

        // Invalid points
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(2L, 0)));

        // Invalid product
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(99L, 100)));

        // Database error
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(2L, 1000)));

        // Success
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(2L, 100)));
    }
    
    private GiftRewardLoyaltyProgram updateLoyaltyProgram(GiftRewardLoyaltyProgram oldLoyaltyProgram,
            GiftRewardLoyaltyProgram newLoyaltyProgram) {
		oldLoyaltyProgram.setNeededPoints(newLoyaltyProgram.getNeededPoints());
		oldLoyaltyProgram.setProductId(newLoyaltyProgram.getProductId());
		
		return oldLoyaltyProgram;
	}

    /**
     * Here also the function will return an instance of GiftRewardLoyaltyProgram instead of boolean.
     * The idea is, if the points are valid, we will return the success instance wrapping the 
     * GiftRewardLoyaltyProgram and passing it to the next step in the processing chain.
     * If failure, we wrap the instance with a failure with error message
     * This way, we chain the function with a flatmap as it returns a result
     */
    private Result<GiftRewardLoyaltyProgram> isNumberOfPointsValid(GiftRewardLoyaltyProgram lp) {
        Result<GiftRewardLoyaltyProgram> result = null;

        if(lp.getNeededPoints() != null || lp.getNeededPoints() > 0) {
            result = Result.success(lp);
        }else{
        	result = Result.failure("Invalid points");
        }

        return result;
    }

    /**
     * Here we check first if the product we are going to update is actually present
     * in the database or not
     */
    private Result<GiftRewardLoyaltyProgram> isProductValid(GiftRewardLoyaltyProgram lp) {
    	return Result.of(lp)
                .filter(newLp -> productRepository.getProductById(newLp.getProductId()) != null,
                        "Invalid product");
    }
}

class ProductRepository {
    public Product getProductById(Long id) {
    	// For testing purpose simulating error if ID equals 99, return null
        if(id == 99) {
            return null;
        }
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
    	// For testing if neededPoints == 1000 we'll return a failure SIMLUATING ERROR
        if(lp.getNeededPoints() == 1000) {
            throw new RuntimeException("Database error");
        }
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
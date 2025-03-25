package com.example.insurance.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class InsuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Add primary key field

    @Pattern(regexp = "^[a-zA-Z ]+$", message = "only alphabets")
    private String customerName;

    @Min(value = 18, message = "below 18")
    @Max(value = 60, message = "max 60")
    private int age;

    @Pattern(regexp = "^(individual|family|senior)$", message = "INVALID NAME individual|family|senior")
    private String insuranceType;

    @Min(value = 100000, message = "below 100000")
    @Max(value = 2000000, message = "max 2000000")
    private int sumInterest;

    @Min(value = 1, message = "below 1")
    @Max(value = 5, message = "max 5")
    private int premiumRate;


    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public int getSumInterest() {
		return sumInterest;
	}

	public void setSumInterest(int sumInterest) {
		this.sumInterest = sumInterest;
	}

	public int getPremiumRate() {
		return premiumRate;
	}

	public void setPremiumRate(int premiumRate) {
		this.premiumRate = premiumRate;
	}

	public Long getId() {
		return id;
	}

	public InsuEntity(Long id, @Pattern(regexp = "^[a-zA-Z ]+$", message = "only alphabets") String customerName,
			@Min(value = 18, message = "below 18") @Max(value = 60, message = "max 60") int age,
			@Pattern(regexp = "^(individual|family|senior)$", message = "INVALID NAME individual|family|senior") String insuranceType,
			@Min(value = 100000, message = "below 100000") @Max(value = 2000000, message = "max 2000000") int sumInterest,
			@Min(value = 1, message = "below 1") @Max(value = 5, message = "max 5") int premiumRate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.age = age;
		this.insuranceType = insuranceType;
		this.sumInterest = sumInterest;
		this.premiumRate = premiumRate;
	}

	@Override
	public String toString() {
		return "InsuEntity [id=" + id + ", customerName=" + customerName + ", age=" + age + ", insuranceType="
				+ insuranceType + ", sumInterest=" + sumInterest + ", premiumRate=" + premiumRate + "]";
	}

	public InsuEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	


}

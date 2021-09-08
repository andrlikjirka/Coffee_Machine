package model;

/**
 * Coffee Machine Model
 * @author Jirka Andrlík
 */
public class CoffeeMachineModel {
    /** Water Supply Attribute */
    private int waterSupply;
    /** Milk Supply Attribute */
    private int milkSupply;
    /** Beans Supply Attribute */
    private int beansSupply;
    /** Disposable cups Attribute */
    private int disposableCups;
    /** Money Attribute */
    private int money;

    /**
     * Constructor creates new object
     * @param waterSupply Water supply
     * @param milkSupply Milk supply
     * @param beansSupply Beans supply
     * @param disposableCups Disposable cups
     * @param money Money
     */
    public CoffeeMachineModel(int waterSupply, int milkSupply, int beansSupply, int disposableCups, int money) {
        this.waterSupply = waterSupply;
        this.milkSupply = milkSupply;
        this.beansSupply = beansSupply;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    /**
     * Getter for Water Supply
     * @return Water Supply
     */
    public int getWaterSupply() {
        return waterSupply;
    }

    /**
     * Getter for Milk Supply
     * @return Milk Supply
     */
    public int getMilkSupply() {
        return milkSupply;
    }

    /**
     * Getter for Beans Supply
     * @return Beans Supply
     */
    public int getBeansSupply() {
        return beansSupply;
    }

    /**
     * Getter for Disposable Cups
     * @return Disposable Cups
     */
    public int getDisposableCups() {
        return disposableCups;
    }

    /**
     * Getter for Money
     * @return Money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Setter for Water supply
     * @param waterSupply Water supply
     */
    public void setWaterSupply(int waterSupply) {
        this.waterSupply = waterSupply;
    }

    /**
     * Setter for Milk Supply
     * @param milkSupply Milk supply
     */
    public void setMilkSupply(int milkSupply) {
        this.milkSupply = milkSupply;
    }

    /**
     * Setter for Beans Supply
     * @param beansSupply Beans supply
     */
    public void setBeansSupply(int beansSupply) {
        this.beansSupply = beansSupply;
    }

    /**
     * Setter for Disposable Cups
     * @param disposableCups Disposable cups
     */
    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    /**
     * Setter for money
     * @param money Money
     */
    public void setMoney(int money) {
        this.money = money;
    }
}

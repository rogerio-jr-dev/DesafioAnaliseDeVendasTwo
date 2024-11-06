package entities;

public class Sale {

    private Integer month;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
        this.month = month;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getItems() {
        return items;
    }


    public Double getTotal() {
        return total;
    }

    public Double averagePrice() {
        if (items == 0) {
            return 0.0;  // Evita divisão por zero
        }
        return getTotal() / getItems();
    }

}
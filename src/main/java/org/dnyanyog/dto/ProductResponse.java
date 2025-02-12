package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
    
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String responseCode;
    private String responseMessage;

   
    

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getResponseCode() { return responseCode; }
    public void setResponseCode(String responseCode) { this.responseCode = responseCode; }

    public String getResponseMessage() { return responseMessage; }
    public void setResponseMessage(String responseMessage) { this.responseMessage = responseMessage; }

    @Override
    public String toString() {
        return "ProductResponse { id=" + id + ", name='" + name + "', price=" + price + ", quantity=" + quantity +
                ", responseCode='" + responseCode + "', responseMessage='" + responseMessage + "' }";
    }
}

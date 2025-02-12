package org.dnyanyog.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    ProductResponse productResponse;

    public ProductResponse searchProduct(int id) {
        String query ="SELECT * FROM product WHERE product_id = "+ id+"";

        try  {
            ResultSet rs = DBUtils.executeSelectQuery(query);
            if (rs.next()) {
                productResponse.setId(rs.getInt("product_id"));
                productResponse.setName(rs.getString("product_name"));
                productResponse.setPrice(rs.getInt("product_price"));
                productResponse.setQuantity(rs.getInt("product_quantity"));
                productResponse.setResponseCode("0000");
                productResponse.setResponseMessage("Product details fetched successfully!");
            } else {
                productResponse.setResponseCode("911");
                productResponse.setResponseMessage("Product not found!");
            }
            rs.close();
        } catch (SQLException e) {
            productResponse.setResponseCode("911");
            productResponse.setResponseMessage("Database error: " + e.getMessage());
        }
        return productResponse;
    }

    public ProductResponse saveProduct(ProductRequest product) {
        String query = "INSERT INTO product (product_name, product_price, product_quantity) VALUES ('" 
                       + product.getName() + "', " + product.getPrice() + ", " + product.getQuantity() + ")";
        
        try  {
            DBUtils.executeDMLQuery(query);

            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setQuantity(product.getQuantity());
            productResponse.setResponseCode("0000");
            productResponse.setResponseMessage("Product added successfully!");
        } catch (SQLException e) {
            productResponse.setResponseCode("911");
            productResponse.setResponseMessage("Product addition failed: " + e.getMessage());
        }
        return productResponse;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productListResponse = new ArrayList<>();
        String query = "SELECT * FROM product";

        try  {
            ResultSet rs = DBUtils.executeSelectQuery(query);
            while (rs.next()) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(rs.getInt("product_id"));
                productResponse.setName(rs.getString("product_name"));
                productResponse.setPrice(rs.getInt("product_price"));
                productResponse.setQuantity(rs.getInt("product_quantity"));
                productResponse.setResponseCode("0000");
                productResponse.setResponseMessage("Product details fetched successfully!");
                productListResponse.add(productResponse);
            }
            rs.close();
        } catch (SQLException e) {
            productResponse.setResponseCode("911");
            productResponse.setResponseMessage("Database error: " + e.getMessage());
            productListResponse.add(productResponse);
        }
        return productListResponse;
    }
}

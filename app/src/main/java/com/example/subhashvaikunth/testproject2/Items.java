package com.example.subhashvaikunth.testproject2;

import java.io.Serializable;

/**
 * Created by SUBHASH VAIKUNTH on 4/3/2016.
 */
public class Items extends Custom_attributes implements Serializable {
    private String status;

    private String visibility;

    private Custom_attributes[] custom_attributes;

    private String sku;
    private String image;

    private String attribute_set_id;

    private String type_id;

    private String id;

    private String price;

    private String updated_at;

    private String name;

    private String created_at;

    private Product_links[] product_links;

    private String[] tier_prices;

    private String[] options;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public Custom_attributes[] getCustom_attributes ()
    {
        return custom_attributes;
    }

    public void setCustom_attributes (Custom_attributes[] custom_attributes)
    {
        this.custom_attributes = custom_attributes;
    }

    public String getSku ()
    {
        return sku;
    }

    public void setSku (String sku)
    {
        this.sku = sku;
    }
    public  String getImage(){
        return image;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getAttribute_set_id ()
    {
        return attribute_set_id;
    }

    public void setAttribute_set_id (String attribute_set_id)
    {
        this.attribute_set_id = attribute_set_id;
    }

    public String getType_id ()
    {
        return type_id;
    }

    public void setType_id (String type_id)
    {
        this.type_id = type_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public Product_links[] getProduct_links ()
    {
        return product_links;
    }

    public void setProduct_links (Product_links[] product_links)
    {
        this.product_links = product_links;
    }

    public String[] getTier_prices ()
    {
        return tier_prices;
    }

    public void setTier_prices (String[] tier_prices)
    {
        this.tier_prices = tier_prices;
    }

    public String[] getOptions ()
    {
        return options;
    }

    public void setOptions (String[] options)
    {
        this.options = options;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", visibility = "+visibility+", custom_attributes = "+custom_attributes+", sku = "+sku+", attribute_set_id = "+attribute_set_id+", type_id = "+type_id+", id = "+id+", price = "+price+", updated_at = "+updated_at+", name = "+name+", created_at = "+created_at+", product_links = "+product_links+", tier_prices = "+tier_prices+", options = "+options+"]";
    }




}

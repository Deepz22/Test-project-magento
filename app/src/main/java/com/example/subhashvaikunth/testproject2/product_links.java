package com.example.subhashvaikunth.testproject2;

/**
 * Created by SUBHASH VAIKUNTH on 3/28/2016.
 */
class Product_links {
//    private null position;

    private String linked_product_type;

    private String linked_product_sku;

    private String[] extension_attributes;

    private String sku;

    private String link_type;

//    public null getPosition ()
//    {
//        return position;
//    }
//
//    public void setPosition (null position)
//    {
//        this.position = position;
//    }

    public String getLinked_product_type ()
    {
        return linked_product_type;
    }

    public void setLinked_product_type (String linked_product_type)
    {
        this.linked_product_type = linked_product_type;
    }

    public String getLinked_product_sku ()
    {
        return linked_product_sku;
    }

    public void setLinked_product_sku (String linked_product_sku)
    {
        this.linked_product_sku = linked_product_sku;
    }

    public String[] getExtension_attributes ()
    {
        return extension_attributes;
    }

    public void setExtension_attributes (String[] extension_attributes)
    {
        this.extension_attributes = extension_attributes;
    }

    public String getSku ()
    {
        return sku;
    }

    public void setSku (String sku)
    {
        this.sku = sku;
    }

    public String getLink_type ()
    {
        return link_type;
    }

    public void setLink_type (String link_type)
    {
        this.link_type = link_type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ linked_product_type = "+linked_product_type+", linked_product_sku = "+linked_product_sku+", extension_attributes = "+extension_attributes+", sku = "+sku+", link_type = "+link_type+"]";
    }
}

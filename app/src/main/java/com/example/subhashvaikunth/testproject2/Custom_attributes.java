package com.example.subhashvaikunth.testproject2;

/**
 * Created by SUBHASH VAIKUNTH on 4/2/2016.
 */
public class Custom_attributes {


    private String value;
    private String image;

    private String attribute_code;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getAttribute_code ()
    {

        return attribute_code;
    }
    public  String getImage(){

        return image;
    }
    public void setImage(String image)
    {
        this.image = image;
    }
    public void setAttribute_code (String attribute_code)
    {

        this.attribute_code = attribute_code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", attribute_code = "+attribute_code+"]";
    }



}

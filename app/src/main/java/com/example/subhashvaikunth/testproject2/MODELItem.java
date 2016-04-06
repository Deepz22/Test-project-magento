package com.example.subhashvaikunth.testproject2;

import java.io.Serializable;


public class MODELItem extends Items implements Serializable{


    private Search_criteria search_criteria;

    private Items[] items;

    private String total_count;

    public Search_criteria getSearch_criteria ()
    {
        return search_criteria;
    }

    public void setSearch_criteria (Search_criteria search_criteria)
    {
        this.search_criteria = search_criteria;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [search_criteria = "+search_criteria+", items = "+items+", total_count = "+total_count+"]";
    }
}



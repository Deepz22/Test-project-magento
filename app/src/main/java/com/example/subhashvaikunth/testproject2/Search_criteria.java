package com.example.subhashvaikunth.testproject2;

/**
 * Created by SUBHASH VAIKUNTH on 4/3/2016.
 */
public class Search_criteria {
    private String page_size;

    private String[] filter_groups;

    public String getPage_size ()
    {
        return page_size;
    }

    public void setPage_size (String page_size)
    {
        this.page_size = page_size;
    }

    public String[] getFilter_groups ()
    {
        return filter_groups;
    }

    public void setFilter_groups (String[] filter_groups)
    {
        this.filter_groups = filter_groups;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [page_size = "+page_size+", filter_groups = "+filter_groups+"]";
    }


}

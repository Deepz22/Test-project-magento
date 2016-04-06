package com.example.subhashvaikunth.testproject2;

/**
 * Created by SUBHASH VAIKUNTH on 3/27/2016.
 */
public class Media_gallery_entries
{
    private String position;

    private String id;

    private String media_type;

    private String file;

    private String label;

    private String[] types;

    private String disabled;

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getMedia_type ()
    {
        return media_type;
    }

    public void setMedia_type (String media_type)
    {
        this.media_type = media_type;
    }

    public String getFile ()
    {
        return file;
    }

    public void setFile (String file)
    {
        this.file = file;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String[] getTypes ()
    {
        return types;
    }

    public void setTypes (String[] types)
    {
        this.types = types;
    }

    public String getDisabled ()
    {
        return disabled;
    }

    public void setDisabled (String disabled)
    {
        this.disabled = disabled;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", id = "+id+", media_type = "+media_type+", file = "+file+", label = "+label+", types = "+types+", disabled = "+disabled+"]";
    }
}


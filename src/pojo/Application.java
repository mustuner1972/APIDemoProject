package pojo;

import java.util.ArrayList;

public class Application {
    private String title;
    private float id;
    private boolean children;
    ArrayList<Object> groups = new ArrayList<Object>();


    // Getter Methods

    public String getTitle() {
        return title;
    }

    public float getId() {
        return id;
    }

    public boolean getChildren() {
        return children;
    }

    // Setter Methods

    public void setTitle( String title ) {
        this.title = title;
    }

    public void setId( float id ) {
        this.id = id;
    }

    public void setChildren( boolean children ) {
        this.children = children;
    }
}
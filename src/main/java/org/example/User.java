package org.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class User {

    private int id;
    private String name;
    private String createdBy;
    private LocalDate createdDate;

    private final PropertyChangeSupport propertySupport ;

    public User() {
        this.propertySupport = new PropertyChangeSupport(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertySupport.firePropertyChange("id", oldId, this.id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertySupport.firePropertyChange("name", oldName, this.name);

    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;

    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        LocalDate old = this.createdDate;
        this.createdDate = createdDate;
        propertySupport.firePropertyChange("createdDate", old, this.createdDate);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
}

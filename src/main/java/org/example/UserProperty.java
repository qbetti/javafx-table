package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;

import java.time.LocalDate;

public class UserProperty {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty createdBy;
    private ObjectProperty<LocalDate> createdDate;

    public UserProperty(User user) {
        try {
            id = JavaBeanIntegerPropertyBuilder.create()
                    .bean(user)
                    .name("id")
                    .build();

            name = JavaBeanStringPropertyBuilder.create()
                    .bean(user)
                    .name("name")
                    .build();

            createdBy = JavaBeanStringPropertyBuilder.create()
                    .bean(user)
                    .name("createdBy")
                    .build();

            createdDate = JavaBeanObjectPropertyBuilder.create()
                    .bean(user)
                    .name("createdDate")
                    .build();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public final IntegerProperty idProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public final StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public final StringProperty createdByProperty() {
        return createdBy;
    }

    public String getCreatedBy() {
        return createdBy.get();
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy.set(createdBy);
    }

    public final ObjectProperty<LocalDate> createdDateProperty() {
        return createdDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate.get();
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate.set(createdDate);
    }
}

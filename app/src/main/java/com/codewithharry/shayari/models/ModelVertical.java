package com.codewithharry.shayari.models;

import java.util.ArrayList;
import java.util.List;

public class ModelVertical {
    String title;
    List<ModelHorizonatal> arrayList;


    public ModelVertical(String title, List<ModelHorizonatal> arrayList) {
        this.title = title;
        this.arrayList = arrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ModelHorizonatal> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<ModelHorizonatal> arrayList) {
        this.arrayList = arrayList;
    }
}

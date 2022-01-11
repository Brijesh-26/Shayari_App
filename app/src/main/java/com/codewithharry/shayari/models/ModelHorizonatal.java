package com.codewithharry.shayari.models;

import android.widget.ImageView;
import android.widget.TextView;

public class ModelHorizonatal {

    int imageView_horizontal;
    String name_horizontal;

    public ModelHorizonatal(int imageView_horizontal, String name_horizontal) {
        this.imageView_horizontal = imageView_horizontal;
        this.name_horizontal = name_horizontal;
    }

    public int getImageView_horizontal() {
        return imageView_horizontal;
    }

    public void setImageView_horizontal(int imageView_horizontal) {
        this.imageView_horizontal = imageView_horizontal;
    }

    public String getName_horizontal() {
        return name_horizontal;
    }

    public void setName_horizontal(String name_horizontal) {
        this.name_horizontal = name_horizontal;
    }
}

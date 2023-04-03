package com.example.pathofgun;

import android.os.Parcel;

public class Accesoires {
    private final int defaultQuantity;
    private Item item;
    private String unity;

    public Ingredient(Item item, int defaultQuantity, String unity) {
        this.item = item;
        this.defaultQuantity = defaultQuantity;
        this.unity = unity;
    }

    protected Ingredient(Parcel in) {
        defaultQuantity = in.readInt();
        unity = in.readString();
        item = Item.valueOf(in.readString());
    }

    public int getDefaultQuantity() {
        return defaultQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "defaultQuantity=" + defaultQuantity +
                ", item=" + item +
                ", unity='" + unity + '\'' +
                '}';
    }
}

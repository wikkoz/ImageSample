package com.uczymy.marte.model;

import java.awt.image.BufferedImage;

public class Model {
    private BufferedImage originalImage;
    private BufferedImage modifiedImage;
    private String chosenModifier;

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getModifiedImage() {
        return modifiedImage;
    }

    public void setModifiedImage(BufferedImage modifiedImage) {
        this.modifiedImage = modifiedImage;
    }

    public String getChosenModifier() {
        return chosenModifier;
    }

    public void setChosenModifier(String chosenModifier) {
        this.chosenModifier = chosenModifier;
    }
}

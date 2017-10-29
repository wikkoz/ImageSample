package com.uczymy.marte.controller.listeners;

import com.uczymy.marte.model.Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class OpenFileListener {

    private Model model;

    OpenFileListener(Model model) {
        this.model = model;
    }

    public BufferedImage openImageFile(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            model.setOriginalImage(image);
            return image;
        } catch (Exception ex) {
            System.out.println("problem accessing file"+file.getAbsolutePath());
        }
        return null;
    }
}

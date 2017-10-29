package com.uczymy.marte.controller.modifires;



import org.apache.commons.lang3.tuple.Triple;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

class TestModifier implements Modifier {
    @Override
    public BufferedImage modify(BufferedImage image) {
        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        IntStream.range(0, image.getWidth())
                .boxed()
                .flatMap(x -> IntStream.range(0, image.getHeight())
                        .boxed()
                        .map(y -> Triple.of(x, y, getColor(image, x, y))))
                .forEach(color -> copy.setRGB(color.getLeft(), color.getMiddle(), color.getRight().getRGB()));
        return copy;
    }

    @Override
    public String name() {
        return "nic nie robie 2";
    }

    private Color getColor(BufferedImage image, int x, int y) {
        int rgba = image.getRGB(x, y);
        Color col = new Color(rgba, true);
        return new Color(255 - col.getRed(),
                255 - col.getGreen(),
                255 - col.getBlue());
    }
}

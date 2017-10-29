package com.uczymy.marte.controller.modifires;

import java.awt.image.BufferedImage;


class TemplateModifier implements Modifier {
    public BufferedImage modify(BufferedImage image) {
        return image;
    }

    public String name() {
        return "nic nie robie";
    }
}

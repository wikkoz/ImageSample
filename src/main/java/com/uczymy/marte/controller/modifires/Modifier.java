package com.uczymy.marte.controller.modifires;

import java.awt.image.BufferedImage;

public interface Modifier {
    BufferedImage modify(BufferedImage image);
    String name();
}

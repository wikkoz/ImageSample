package com.uczymy.marte.controller.listeners;

import com.uczymy.marte.controller.modifires.Modifier;
import com.uczymy.marte.controller.modifires.ModifiersConfig;
import com.uczymy.marte.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonClickListener implements ActionListener {
    private Model model;
    private ModifiersConfig config;

    ButtonClickListener(Model model, ModifiersConfig config) {
        this.model = model;
        this.config = config;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Modifier modifier = config.getModifier(model.getChosenModifier());
        model.setModifiedImage(modifier.modify(model.getOriginalImage()));
    }
}

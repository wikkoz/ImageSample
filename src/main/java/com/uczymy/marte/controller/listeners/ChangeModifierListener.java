package com.uczymy.marte.controller.listeners;

import com.uczymy.marte.model.Model;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ChangeModifierListener implements ItemListener {

    private Model model;

    ChangeModifierListener(Model model) {
        this.model = model;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            model.setChosenModifier(String.valueOf(e.getItem()));
        }
    }
}

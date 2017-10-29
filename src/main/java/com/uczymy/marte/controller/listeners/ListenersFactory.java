package com.uczymy.marte.controller.listeners;

import com.uczymy.marte.controller.modifires.ModifiersConfig;
import com.uczymy.marte.model.Model;

public class ListenersFactory {
    public static Listeners createListeners(Model model, ModifiersConfig config) {
        return new Listeners.Builder()
                .withButtonClickListener(new ButtonClickListener(model, config))
                .withChangeModifierListener(new ChangeModifierListener(model))
                .withOpenFileListener(new OpenFileListener(model))
                .build();
    }
}

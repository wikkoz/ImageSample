package com.uczymy.marte;

import com.uczymy.marte.controller.listeners.ListenersFactory;
import com.uczymy.marte.controller.modifires.ModifiersConfig;
import com.uczymy.marte.controller.listeners.Listeners;
import com.uczymy.marte.model.Model;
import com.uczymy.marte.view.Window;

public class Main {

    public static void main(String[] args) {
        ModifiersConfig config = ModifiersConfig.createAndInit();
        Model model = new Model();
        Listeners listeners = ListenersFactory.createListeners(model, config);
        Window.create(model, config.getAllNames(), listeners).initialize();
    }
}

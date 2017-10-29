package com.uczymy.marte.controller.modifires;


import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModifiersConfig {
    private Map<String, Modifier> modifiers = Collections.emptyMap();

    public static ModifiersConfig createAndInit () {
        ModifiersConfig config = new ModifiersConfig();
        config.modifiers = Lists.newArrayList(
                (Modifier) new TemplateModifier(),
                (Modifier) new TestModifier()
        ).stream()
                .collect(Collectors.toMap(Modifier::name, m -> m));
        return config;
    }

    public Modifier getModifier(String name) {
        return modifiers.get(name);
    }

    public Set<String> getAllNames() {
        return modifiers.keySet();
    }
}

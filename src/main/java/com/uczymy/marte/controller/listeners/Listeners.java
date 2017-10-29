package com.uczymy.marte.controller.listeners;


public class Listeners {

    static class Builder {
        private Listeners listeners;

        Builder() {
            this.listeners = new Listeners();
        }

        Builder withButtonClickListener(ButtonClickListener buttonClickListener) {
            listeners.buttonClickListener = buttonClickListener;
            return this;
        }

        Builder withChangeModifierListener(ChangeModifierListener changeModifierListener) {
            listeners.changeModifierListener = changeModifierListener;
            return this;
        }

        Builder withOpenFileListener(OpenFileListener openFileListener) {
            listeners.openFileListener = openFileListener;
            return this;
        }

        Listeners build() {
            return listeners;
        }
    }

    private ButtonClickListener buttonClickListener;
    private ChangeModifierListener changeModifierListener;
    private OpenFileListener openFileListener;

    public ButtonClickListener getButtonClickListener() {
        return buttonClickListener;
    }

    public ChangeModifierListener getChangeModifierListener() {
        return changeModifierListener;
    }

    public OpenFileListener getOpenFileListener() {
        return openFileListener;
    }
}

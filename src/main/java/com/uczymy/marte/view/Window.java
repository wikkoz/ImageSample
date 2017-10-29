package com.uczymy.marte.view;

import com.uczymy.marte.controller.listeners.Listeners;
import com.uczymy.marte.model.Model;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Set;

public class Window {

    private Model model;
    private JButton button;
    private JButton fileChooserButton;
    private JFrame frame;
    private JComboBox<String> modifiers;
    private Image originalImage;
    private Image modifiedImage;
    private JFileChooser fileChooser;
    private Listeners listeners;


    public static Window create(Model model, Set<String> modifiers, Listeners listeners) {
        Window w = new Window(model, modifiers, listeners);
        model.setChosenModifier(modifiers.iterator().next());
        return w;
    }

    private Window(Model model, Set<String> modifiers, Listeners listeners) {
        button = new JButton("Modify");
        fileChooserButton = new JButton("Open file");
        frame = new JFrame();
        this.modifiers = new JComboBox<>(modifiers.toArray(new String[modifiers.size()]));
        originalImage = new Image();
        modifiedImage = new Image();
        fileChooser = new JFileChooser();
        this.model = model;
        this.listeners = listeners;
    }

    public void initialize() {
        buttonInitialize();
        modifiersInitialize();
        imagesInitialize();
        frameInitialize();
    }

    private void imagesInitialize() {
        modifiedImage.setBounds(650, 100, 500, 400);
        originalImage.setBounds(50, 100, 500, 400);
    }

    private void buttonInitialize() {
        button.addActionListener(l -> {
            listeners.getButtonClickListener().actionPerformed(l);
            modifiedImage.setImage(model.getModifiedImage());
            modifiedImage.repaint();
        });
        button.setBounds(150, 610, 300, 40);
        fileChooserButton.setBounds(150,50,300,40);
        fileChooserButton.addActionListener(e -> openFileListener());
    }

    private void modifiersInitialize() {
        modifiers.setEditable(false);
        modifiers.addItemListener(listeners.getChangeModifierListener());
        modifiers.setBounds(150, 550, 300, 40);
    }

    private void frameInitialize() {
        frame.setSize(1200, 800);
        frame.setLayout(null);
        frame.add(button);
        frame.add(modifiers);
        frame.setVisible(true);
        frame.add(fileChooserButton);
        frame.add(originalImage);
        frame.add(fileChooserButton);
        frame.add(modifiedImage);
    }

    private void openFileListener() {
        int returnVal = fileChooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedImage image = listeners.getOpenFileListener().openImageFile(file);
            originalImage.setImage(image);
            originalImage.repaint();
        }
    }
}

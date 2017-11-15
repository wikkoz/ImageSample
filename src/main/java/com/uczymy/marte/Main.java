package com.uczymy.marte;

import com.uczymy.marte.controller.listeners.ListenersFactory;
import com.uczymy.marte.controller.modifires.ModifiersConfig;
import com.uczymy.marte.controller.listeners.Listeners;
import com.uczymy.marte.model.Model;
import com.uczymy.marte.view.Window;
import javafx.scene.shape.Rectangle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Main {

    public static void main(String[] args) {
//        ModifiersConfig config = ModifiersConfig.createAndInit();
//        Model model = new Model();
//        Listeners listeners = ListenersFactory.createListeners(model, config);
//        Window.create(model, config.getAllNames(), listeners).initialize();
        Square r = new Rectangle(2,2);
        Square s = new Square(2);

        System.out.println(r.equals(s));
        System.out.println(s.equals(r));
    }

    private static class Square {
        private int a;

        public Square(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        public Square setA(int a) {
            this.a = a;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Square square = (Square) o;

            return new EqualsBuilder()
                    .append(a, square.a)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(a)
                    .toHashCode();
        }
    }

    private static class Rectangle extends Square {
        private int b;

        public Rectangle(int a, int b) {
            super(a);
            this.b = b;
        }

        public int getB() {
            return b;
        }

        public Rectangle setB(int b) {
            this.b = b;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Rectangle rectangle = (Rectangle) o;

            return new EqualsBuilder()
                    .appendSuper(super.equals(o))
                    .append(b, rectangle.b)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .appendSuper(super.hashCode())
                    .append(b)
                    .toHashCode();
        }
    }
}

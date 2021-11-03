package com.github.yyy123454321.quadratic_function;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {
    private int minX, minY, maxX, maxY;
    private int a, b, c;
    private int magnification;

    public Window(int minX, int minY, int maxX, int maxY, int magnification, int a, int b, int c) {
        setSize(
                (maxX - minX + 1) * magnification,
                (maxY - minY + 1) * magnification
        );

        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;

        this.magnification = magnification;

        this.a = a;
        this.b = b;
        this.c = c;

        setVisible(true);
    }

    public void paint(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage((maxX - minX + 1), (maxY - minY + 1), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics imageGraphics = bufferedImage.getGraphics();

        imageGraphics.clearRect(0, 0, (maxX - minX + 1), (maxY - minY + 1));
        imageGraphics.setColor(Color.RED);
        imageGraphics.drawLine(-minX, 0, -minX, (maxY - minY + 1));
        imageGraphics.drawLine(0, maxY + 1, (maxX - minX + 1), maxY + 1);

        imageGraphics.setColor(Color.WHITE);
        for (int i = minX; i <= maxX; i++) {
            int y = (a * (i * i)) + (b * i) + c;
            int lastY = (a * ((i - 1) * (i - 1))) + (b * (i - 1)) + c;
            imageGraphics.drawLine(
                    i - minX, maxY + 1 - y,
                    i - 1 - minX, maxY + 1 - lastY
            );
        }

        g.drawImage(
                bufferedImage,
                0,
                0,
                (maxX - minX + 1) * magnification,
                (maxY - minY + 1) * magnification,
                this
        );
    }
}

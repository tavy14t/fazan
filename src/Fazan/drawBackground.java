/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fazan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 *
 * @author Tavy
 */
public class drawBackground extends JPanel {
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        GradientPaint gp = new GradientPaint(0,0,new Color(255,201,14),0, 560, new Color(0,64,0));
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, 655, 560, 15, 15);
        GradientPaint gp2 = new GradientPaint(0,560,new Color(255,201,14),0, 0, new Color(0,64,0));
        g2.setPaint(gp2);
        g2.setStroke( new BasicStroke(6));
        g2.drawRect(180,113,295,430);
        //g2.fillRect(0,0,655,560);
        }
}

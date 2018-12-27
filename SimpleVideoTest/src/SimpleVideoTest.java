package com.company;
import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.video.MarvinJavaCVAdapter;
import marvin.video.MarvinVideoInterface;
import marvin.video.MarvinVideoInterfaceException;

import javax.swing.*;

public class SimpleVideoTest extends JFrame implements Runnable {

    MarvinVideoInterface videoAdapter;
    MarvinImage image;
    MarvinImagePanel videoPanel;

    public SimpleVideoTest() throws MarvinVideoInterfaceException {
        super("Simple Video Test");
        videoAdapter = new MarvinJavaCVAdapter();
        videoAdapter.connect(0);
        videoPanel = new MarvinImagePanel();
        add(videoPanel);
        new Thread(this).start();
        setSize(800,600);
        setVisible(true);
    }
    @Override
    public void run() {
        while(true){
            try {
                image = videoAdapter.getFrame();
            } catch (MarvinVideoInterfaceException e) {
                e.printStackTrace();
            }
            videoPanel.setImage(image);
        }
    }
    public static void main(String[] args) throws MarvinVideoInterfaceException {
	// write your code here
        SimpleVideoTest t = new SimpleVideoTest();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

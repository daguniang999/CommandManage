package com.asteroid.command.manage.frame;

import javax.swing.*;
import java.awt.*;

public class CommandFrameMain extends JFrame {

    public static void main(String[] args) {
        // 创建一个窗口对象
        new CommandFrameMain();
    }

    public CommandFrameMain() {
        // 设置显示窗口标题
        setTitle("Save Your Command Line");
        // 设置窗口显示尺寸
        setSize(400,200);
        // 置窗口是否可以关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = createPanel(Color.WHITE);
        this.setContentPane(jPanel);

        // 获取当前窗口的内容窗格
        // Container c = getContentPane();
        // c.add(createButton());
//        c.add(createButton());

        jPanel.add(createPanel(Color.BLACK));
        jPanel.add(createPanel(Color.YELLOW));
        jPanel.add(createPanel(Color.RED));





        // 设置窗口是否可见
        setVisible(true);
    }

    public JButton createButton() {
        // 创建一个按钮
        JButton testButton = new JButton();
        testButton.setText("test");
        return testButton;
    }

    public JLabel createLabel() {
        // 创建一个标签
        JLabel jl = new JLabel("这是使用JFrame类创建的窗口");
        return jl;
    }

    public JPanel createPanel(Color color) {
        // 创建一个面板
        JPanel jPanel = new JPanel();
        jPanel.setBackground(color);
        return jPanel;
    }
}

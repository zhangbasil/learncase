package com.zhangbin.learncase.autotest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author zhangbin
 * @Type ExtendJFrame
 * @Desc
 * @date 2018-05-20
 * @Version V1.0
 */
public class ExtendJFrame extends JFrame implements ActionListener {
    /**
     * 当前窗体的构造函数
     * 对当前窗体进行基本的设置。
     */
    private ExtendJFrame() {
        super("我的自动化");
        setSize(1500, 800);
        // 窗口居中
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        // 2. 创建中间容器（面板容器）
        JPanel panel = new JPanel(); // 创建面板容器，使用默认的布局管理器
        // 3. 创建一个基本组件（按钮），并添加到 面板容器 中
        JButton btn = new JButton("点我");
        panel.add(btn);
        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
        setContentPane(panel);
        // 5. 显示窗口，前面创建的信息都在内存中，通过 setVisible(true) 把内存中的窗口显示在屏幕上。
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExtendJFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

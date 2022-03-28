package com.lee.view;

import com.lee.model.Student;
import com.lee.service.ConcreteStudentService;
import com.lee.service.StudentService;
import jdk.nashorn.internal.scripts.JD;
import sun.java2d.Disposer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * com.lee.view
 *
 * @Classname addStuGui
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/15 星期二 18:54
 */

public class addStuGui {
    private JTextField nameTxt;
    private JTextField ageTxt;
    private JTextField classTxt;
    private JButton upBtn;
    private JPanel jp;

    public JPanel getJp() {
        return jp;
    }

    public addStuGui(Student stu) {
        //更新
        upBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentService ss = new ConcreteStudentService();

                stu.setName(nameTxt.getText());
                stu.setAge(Integer.parseInt(ageTxt.getText()));//Integer.parseInt将整型数据Integer转换为基本数据类型int
                stu.setClasses(classTxt.getText());

                int tag = ss.add(stu);
                if(tag == 0){
                    JOptionPane.showMessageDialog(null,"添加成功");
                    nameTxt.setText("");
                    ageTxt.setText("");
                    classTxt.setText("");
                }else{
                    JOptionPane.showMessageDialog(null,"添加失败");
                }
            }
        });
    }
}

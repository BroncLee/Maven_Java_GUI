package com.lee.view;

import com.lee.model.Student;
import com.lee.service.ConcreteStudentService;
import com.lee.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.SQLOutput;
import java.util.List;

/**
 * com.lee.view
 *
 * @Classname Gui
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 星期一 10:26
 */


public class Gui {
    private static List<Student> stuList = null;
    private static int index = 0;
    private static Student stu = null;
    private static StudentService ss = new ConcreteStudentService();
    private JTextField idText;
    private JTextField ageText;
    private JTextField nameText;
    private JTextField classText;
    private JButton insBtn;
    private JButton delBtn;
    private JButton upBtn;
    private JButton preBtn;
    private JPanel panle;
    private JButton nextBtn;
    private JButton firstBtn;
    private JButton findBtn;
    private JTextField findText;

    public Gui() {
        //初始化
        {
            stuList = ss.findAll();
        /*for(int i=0; i<stuList.size(); i++){
            System.out.println(stuList.get(i).getId()+":"+stuList.get(i).getName() +" "+stuList.get(i).getAge());
        }*/
            stu = stuList.get(index);
            idText.setText(stu.getId()+"");
            nameText.setText(stu.getName());
            ageText.setText(stu.getAge()+"");
            classText.setText(stu.getClasses());
        }

        // 新增
        insBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("addStuGui");
                frame.setContentPane(new addStuGui(stu).getJp());
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
                frame.setBounds((d.width - 320)/2,(d.height - 360)/2 ,320, 300);// 窗口的坐标和尺寸，这种方式居中
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        //上一个
        preBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(--index<0)  index = stuList.size()-1;
                stu = stuList.get(index);
                idText.setText(stu.getId()+"");
                nameText.setText(stu.getName());
                ageText.setText(stu.getAge()+"");
                classText.setText(stu.getClasses());
                //System.out.println(index);
            }
        });
        //下一个
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(++index>stuList.size()-1)  index = 0;
                stu = stuList.get(index);
                idText.setText(stu.getId()+"");
                nameText.setText(stu.getName());
                ageText.setText(stu.getAge()+"");
                classText.setText(stu.getClasses());
                //System.out.println(index);
            }
        });
        //首个
        firstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = 0;
                stuList = ss.findAll();
                stu = stuList.get(index);
                idText.setText(stu.getId()+"");
                nameText.setText(stu.getName());
                ageText.setText(stu.getAge()+"");
                classText.setText(stu.getClasses());
                //System.out.println(index);
            }
        });
        //查找
        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stuList = ss.find(findText.getText());

                /*for(int i=0; i<stuList.size(); i++){
                    if(stuList.get(i).getName().equals(findText.getText())){
                        index=i;
                        showMD = false;
                    }
                }*/

                if(stuList.size() == 0){
                    JOptionPane.showMessageDialog(null, "查无此人", "提示",JOptionPane.ERROR_MESSAGE);
                }else{
                    index = 0;
                    stu = stuList.get(index);
                    idText.setText(stu.getId()+"");
                    nameText.setText(stu.getName());
                    ageText.setText(stu.getAge()+"");
                    classText.setText(stu.getClasses());
                }
            }
        });
        //删除
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int delTag = JOptionPane.showConfirmDialog(null, "确定删除  "+ stu.getName() +"  么?后果自负哦！！！", "温馨提示 暖你一整天",JOptionPane.YES_NO_OPTION);
                if(delTag == 0){
                    int _count = ss.delete(stu);
                    if( _count > 0){
                        JOptionPane.showMessageDialog(null, "成功，共删除"+ _count +"条数据", "温馨提示 暖你一整天",JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "删除失败了", "温馨提示 暖你一整天",JOptionPane.ERROR_MESSAGE);
                    }
                }
                stuList = ss.findAll();
            }

        });
        //更新
        upBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stu.setName(nameText.getText());
                stu.setAge(Integer.parseInt(ageText.getText()));
                stu.setClasses(classText.getText());
                int upTag = JOptionPane.showConfirmDialog(null, "确定更新  "+ stu.getId()+"  号的信息么?后果自负哦！！！", "温馨提示 暖你一整天",JOptionPane.YES_NO_OPTION);
                if(upTag == 0){
                    System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getAge());
                    int _count = ss.update(stu);
                    if( _count > 0){
                        JOptionPane.showMessageDialog(null, "成功，共更新"+ _count +"条数据", "温馨提示 暖你一整天",JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "更新失败了", "温馨提示 暖你一整天",JOptionPane.ERROR_MESSAGE);
                    }
                }
                stuList = ss.findAll();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(new Gui().panle);
        frame.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

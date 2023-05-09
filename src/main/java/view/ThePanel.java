package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThePanel extends JFrame implements ActionListener {

    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton resultBtn;
    private javax.swing.JLabel label;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private Controller controller=new Controller();

    public ThePanel(){

        buttonGroup = new javax.swing.ButtonGroup();
        label = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        nextBtn = new javax.swing.JButton();
        resultBtn = new javax.swing.JButton();

        buttonGroup.add(option1);

        buttonGroup.add(option2);

        buttonGroup.add(option3);

        buttonGroup.add(option4);

        nextBtn.setText("Next");
        nextBtn.addActionListener(this);

        resultBtn.setText("Result");
        resultBtn.setEnabled(false);
        resultBtn.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(option1)
                                                        .addComponent(option2)
                                                        .addComponent(option3)
                                                        .addComponent(option4)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(160, 160, 160)
                                                .addComponent(resultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(label)
                                .addGap(35, 35, 35)
                                .addComponent(option1)
                                .addGap(18, 18, 18)
                                .addComponent(option2)
                                .addGap(18, 18, 18)
                                .addComponent(option3)
                                .addGap(18, 18, 18)
                                .addComponent(option4)
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
        setLocation(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ThePanel panel=new ThePanel();
        panel.setVisible(true);
        panel.controller.start(panel.label,panel.option1,panel.option2,panel.option3,panel.option4);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(nextBtn))
            controller.next(label,option1,option2,option3,option4,buttonGroup,nextBtn,resultBtn);
        else if(actionEvent.getSource().equals(resultBtn))
            controller.result();
    }
}

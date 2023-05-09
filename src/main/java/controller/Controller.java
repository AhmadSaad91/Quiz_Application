package controller;

import model.FileOperations;
import model.Questions;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {

    private FileOperations fileOperations=new FileOperations();
    private ArrayList<Questions> questions=fileOperations.readFile();
    private ArrayList<String> answers=new ArrayList<String>();
    private int score=0;
    private int current=1;
    private int pressResultBtn=0;

    public void start(JLabel label, JRadioButton option1, JRadioButton option2, JRadioButton option3, JRadioButton option4) {

        label.setText(questions.get(current).getQuestionLabel());
        option1.setText(questions.get(current).getOption1());
        option2.setText(questions.get(current).getOption2());
        option3.setText(questions.get(current).getOption3());
        option4.setText(questions.get(current).getOption4());
    }
    public void next(JLabel label, JRadioButton option1, JRadioButton option2, JRadioButton option3, JRadioButton option4
            ,ButtonGroup buttonGroup, JButton nextBtn, JButton resultBtn){

        if(current<10) {
            if(option1.isSelected()){

                answers.add(option1.getText());

                updateQuestion(option1,option2,option3
                        ,option4,label,buttonGroup);

            }
            else if(option2.isSelected()){
                answers.add(option2.getText());

                updateQuestion(option1,option2,option3
                        ,option4,label,buttonGroup);
            }
            else if(option3.isSelected()){
                answers.add(option3.getText());

                updateQuestion(option1,option2,option3
                        ,option4,label,buttonGroup);
            }
            else if(option4.isSelected()){
                answers.add(option4.getText());

                updateQuestion(option1,option2,option3
                        ,option4,label,buttonGroup);
            }
            else{
                JOptionPane.showMessageDialog(
                        null,
                        "please select an answer",
                        "warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        }else {
            if(option1.isSelected()) {
                answers.add(option1.getText());
                nextBtn.setEnabled(false);
                resultBtn.setEnabled(true);
            }else if(option2.isSelected()) {
                answers.add(option2.getText());
                nextBtn.setEnabled(false);
                resultBtn.setEnabled(true);
            }else if(option3.isSelected()) {
                answers.add(option3.getText());
                nextBtn.setEnabled(false);
                resultBtn.setEnabled(true);
            }else if(option4.isSelected()) {
                answers.add(option4.getText());
                nextBtn.setEnabled(false);
                resultBtn.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(
                        null,
                        "please select an answer",
                        "warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        }
    }

    public void updateQuestion(JRadioButton option1,JRadioButton option2,JRadioButton option3
            ,JRadioButton option4,JLabel label,ButtonGroup buttonGroup){

        current++;
        buttonGroup.clearSelection();
        start(label,option1,option2,option3,option4);
    }

    public void result(){

        if(pressResultBtn!=0)
            score=0;

        for(int i=0;i<answers.size();i++){
            if(answers.get(i).equals(questions.get(i+1).getCorrectAnswer()))
                score++;
        }

        JOptionPane.showMessageDialog(
                null,
                "Your Score is "+score+" out of 10",
                "Final Score",
                JOptionPane.INFORMATION_MESSAGE
        );

        pressResultBtn++;
    }

}

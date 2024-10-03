import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI {

    int maxAttempts = 10;
    int score = 100;
    int attempts;
    int randomNumber;
    
    public NumberGuessingGameGUI() {
        JFrame frame;
        frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel prompt = new JLabel("Guess a number between 1 and 100:");
        prompt.setBounds(50, 20, 300, 30);
        frame.add(prompt);

        JTextField guess;
        guess = new JTextField();
        guess.setBounds(50, 60, 150, 30);
        frame.add(guess);

        JButton guessButton;
        guessButton = new JButton("Guess");
        guessButton.setBounds(220, 60, 100, 30);
        frame.add(guessButton);

        JButton reset;
        reset = new JButton("Reset");
        reset.setBounds(150, 200, 100, 30);
        frame.add(reset);

        JLabel message;
        message = new JLabel("You have 10 attempts.");
        message.setBounds(50, 100, 300, 30);
        frame.add(message);

        JLabel attempt;
        attempt = new JLabel("Attempts: 0");
        attempt.setBounds(50, 140, 150, 30);
        frame.add(attempt);

        JLabel totalScore;
        totalScore = new JLabel("Score: 100");
        totalScore.setBounds(220, 140, 150, 30);
        frame.add(totalScore);

        
        randomNumber = new Random().nextInt(100) + 1;
        attempts = 0;

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = guess.getText();
                int userGuess;

                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    message.setText("Please enter a valid number.");
                    return;
                }

                attempts++;
                attempt.setText("Attempts: " + attempts);

                if (userGuess < randomNumber) {
                    message.setText("Your guess is too low.");
                } else if (userGuess > randomNumber) {
                    message.setText("Your guess is too high.");
                } else {
                    message.setText("Correct! The number was " + randomNumber);
                    totalScore.setText("Score: " + score);
                }

                if (userGuess != randomNumber) {
                    score -= 10;
                    totalScore.setText("Score: " + score);
                }

                if (attempts >= maxAttempts && userGuess != randomNumber) {
                    message.setText("Game over! The number was " + randomNumber);
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomNumber = new Random().nextInt(100) + 1;
                attempts = 0;
                score = 100;
                message.setText("You have 10 attempts.");
                attempt.setText("Attempts: 0");
                totalScore.setText("Score: 100");
                guess.setText("");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}

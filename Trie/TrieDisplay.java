import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class TrieDisplay extends JPanel implements KeyListener {

    // Variables
    private JFrame frame;
    private int width = 1000, height = 600;
    private Trie trie;
    private String word, likelyChar;
    private Map<Character, Double> frequency;
    private boolean wordsLoaded;

    public TrieDisplay() {

        // Setup
        frame = new JFrame("Trie Next");
        frame.setSize(width, height);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Default Settings
        word = "";
        likelyChar = " "; // Used for single most likely character
        wordsLoaded = false;

        // Load words
        trie = new Trie();
        try {
            Scanner scanner = new Scanner(new File("words.txt"));
            while (scanner.hasNextLine()) {
                trie.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        wordsLoaded = true;
        repaint();

    }

    // Graphics
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Setup and Background
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        g2.setFont(new Font("Arial", Font.BOLD, 60)); // Header
        g2.setColor(Color.WHITE);

        // Loading message
        if (wordsLoaded) {
            g2.drawString("Start Typing:", 40, 100);
        } else {
            g2.drawString("Loading... please wait", 40, 100);
        }

        // Word
        g2.setFont(new Font("Arial", Font.BOLD, 100));
        if (trie.contains(word)) {
            g2.setColor(Color.GREEN);
        } else if (likelyChar.equals("_")) {
            g2.setColor(Color.RED);
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.drawString(word, 40, 250);

        // Top 5 likely characters
        g2.setColor(Color.cyan);
        g2.setFont(new Font("Arial", Font.ITALIC, 18));
        int i = 0;

        if (frequency != null && !frequency.isEmpty()) {
            // Sort the entries by value
            List<Map.Entry<Character, Double>> sortedEntries = frequency.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toList());

            // Display the top 5 entries
            for (Map.Entry<Character, Double> entry : sortedEntries) {
                if (i < 5) {
                    g2.drawString(entry.getKey() + " : " + String.format("%.3f", entry.getValue() * 100) + "%", 40,
                            350 + i * 30);
                    i++;
                }
            }
        } else if (frequency != null && frequency.isEmpty()) {
            g2.drawString("No further possibilities", 40, 350);
        } else {
            g2.drawString("Start Typing", 40, 350);
        }
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == 8) {
            word = word.substring(0, word.length() - 1);
        } else if (keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z) {
            word += KeyEvent.getKeyText(keyCode);
        } else if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        likelyChar = trie.mostLikelyNextChar(word);
        frequency = trie.likelyNextCharsFrequency(word);

        repaint();
    }

    /*** empty methods needed for interfaces **/
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        TrieDisplay app = new TrieDisplay();
    }
}

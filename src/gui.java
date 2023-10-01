import javax.swing.*;
import java.awt.*;

public class gui {
    public static void main(String[] args) {

        Config config = new Config();

        GetSongUseCase getSongUseCase = config.getSongUseCase();
        LogSongUseCase logSongUseCase = config.logSongUseCase();

        // this is the code that runs to set up the GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Spotify GUI App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(850, 300);

            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            JPanel defaultCard = createDefaultCard();
            JPanel getSongCard = createGetSongCard(frame, getSongUseCase);
            JPanel logSongCard = createLogSongCard(frame, logSongUseCase);

            cardPanel.add(defaultCard, "DefaultCard");
            cardPanel.add(getSongCard, "GetSongCard");
            cardPanel.add(logSongCard, "LogSongCard");

            JButton getSongButton = new JButton("Get Song");
            getSongButton.addActionListener(e -> cardLayout.show(cardPanel, "GetSongCard"));

            JButton logSongButton = new JButton("Log Song");
            logSongButton.addActionListener(e -> cardLayout.show(cardPanel, "LogSongCard"));


            JPanel buttonPanel = new JPanel();
            buttonPanel.add(getSongButton);
            buttonPanel.add(logSongButton);

            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);

        });
    }

    private static JPanel createDefaultCard() {
        JPanel defaultCard = new JPanel();
        defaultCard.setLayout(new BorderLayout());

        JLabel infoLabel = new JLabel("Welcome to the Spotify App (GUI Version)!\n" +
                "\t Using API TOKEN: " + MongSong.getApiToken());

        defaultCard.add(infoLabel, BorderLayout.CENTER);

        return defaultCard;
    }

    private static JPanel createGetSongCard(JFrame jFrame, GetSongUseCase getSongUseCase) {
        JPanel getSongCard = new JPanel();
        getSongCard.setLayout(new GridLayout(3, 2));

        JTextField artistField = new JTextField(20);
        JTextField songsField = new JTextField(20);
        JButton getButton = new JButton("Get");

        JLabel resultLabel = new JLabel();

        getButton.addActionListener(e -> {
            String artist = artistField.getText();
            String songs = songsField.getText();

            try{
                Song song = getSongUseCase.getSong(artist, songs);
                JOptionPane.showMessageDialog(jFrame, String.format("Grade: %d", song.getSongs()));
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(jFrame, ex.getMessage());
            }
        });

        getSongCard.add(new JLabel("Artist:"));
        getSongCard.add(artistField);
        getSongCard.add(new JLabel("Songs:"));
        getSongCard.add(songsField);
        getSongCard.add(getButton);
        getSongCard.add(resultLabel);

        return getSongCard;
    }

    private static JPanel createLogSongCard(JFrame jFrame, LogSongUseCase logSongUseCase) {
        JPanel logSongCard = new JPanel();
        logSongCard.setLayout(new GridLayout(4, 2));
        JTextField artistField = new JTextField(20);
        JTextField songField = new JTextField(20);
        JButton logButton = new JButton("Log");
        JLabel resultLabel = new JLabel();

        logButton.addActionListener(e -> {
            String artist = artistField.getText();
            String song = songField.getText();
//            int grade = Integer.parseInt(gradeStr);

            try {
                logSongUseCase.logSong(artist, song);
                JOptionPane.showMessageDialog(jFrame, "Song Added successfully.");
                artistField.setText("");
                songField.setText("");
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(jFrame, ex.getMessage());
            }

        });
        logSongCard.add(new JLabel("Artist:"));
        logSongCard.add(artistField);
        logSongCard.add(new JLabel("Song:"));
        logSongCard.add(songField);
        logSongCard.add(logButton);
        logSongCard.add(resultLabel);


        return logSongCard;
    }


}

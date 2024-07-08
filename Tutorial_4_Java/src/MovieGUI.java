import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieGUI extends JFrame {
    private ArrayList<Movie> movieCollection;
    private DefaultListModel<String> movieListModel;

    public MovieGUI() {
        movieCollection = new ArrayList<>();
        movieListModel = new DefaultListModel<>();
        JList<String> movieList = new JList<>(movieListModel);
        JScrollPane scrollPane = new JScrollPane(movieList);

        JButton addButton = new JButton("Add Movie");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieDialog dialog = new MovieDialog(MovieGUI.this);
                dialog.setVisible(true);
                if (dialog.getCloseOption() == MovieDialog.OK_OPTION) {
                    Movie movie = new Movie();
                    movie.setTitle(dialog.getTitleField());
                    movie.setYear(Integer.parseInt(dialog.getYearField()));
                    addMovie(movie);
                }
            }
        });

        JButton removeButton = new JButton("Remove Movie");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = movieList.getSelectedIndex();
                if (selectedIndex != -1) {
                    removeMovie(selectedIndex);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Movie Collection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addMovie(Movie movie) {
        movieCollection.add(movie);
        movieListModel.addElement(movie.getTitle() + " (" + movie.getYear() + ")");
    }

    private void removeMovie(int index) {
        movieCollection.remove(index);
        movieListModel.remove(index);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MovieGUI().setVisible(true);
            }
        });
    }
}

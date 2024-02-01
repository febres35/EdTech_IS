import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HomeView{

    private String adminUserName;
    private JPanel welcomePanel;

    HomeView(){


        adminUserName = "María Paula Herrero";
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        LocalDate date = LocalDate.now();
        String pattern = "EEEE, d 'de' MMMM 'de' yyyy";
        Locale locale = Locale.forLanguageTag("es");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);

        String formattedDate = date.format(formatter);
        JLabel dateLabel = new JLabel(formattedDate);
        dateLabel.setFont(new Font("Roboto", Font.BOLD, 25));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon certiCompLogo = new ImageIcon("images/CertiComp400.png");
        JLabel logo = new JLabel(certiCompLogo);

        JLabel welcomeUser = new JLabel("¡Hola, "+ adminUserName + "!");
        welcomeUser.setFont(new Font("Roboto", Font.BOLD, 35));
        welcomeUser.setHorizontalAlignment(JLabel.CENTER);

        JLabel adminLabel = new JLabel("Administrador");
        adminLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        adminLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel homeButtons = new JPanel();
        homeButtons.setLayout(new FlowLayout());
        
        ButtonFactory BigFactory = new BigButtonsFactory();
        JButton helpButton  = BigFactory.createButton("Ayuda");
        JButton closeButton = BigFactory.createButton("Cerrar Sesión");

        homeButtons.add(helpButton);
        homeButtons.add(closeButton);
       
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridBagLayout());
        
        homePanel.add(welcomePanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;

        welcomePanel.add(dateLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        welcomePanel.add(logo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        welcomePanel.add(welcomeUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        welcomePanel.add(adminLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(50, 0, 0, 0);
        welcomePanel.add(homeButtons, gbc);
    }

    public JPanel geHomeContent() {
        return welcomePanel;
    }


}
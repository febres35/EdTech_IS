package cienciasucv.certicomp.Views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomeView{

    private JPanel welcomePanel;

    protected HomeView(String userName, String userRole){

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

        JLabel welcomeUser = new JLabel("¡Hola, "+ userName + "!");
        welcomeUser.setFont(new Font("Roboto", Font.BOLD, 35));
        welcomeUser.setHorizontalAlignment(JLabel.CENTER);

        JLabel adminLabel = new JLabel(userRole);
        adminLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        adminLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel homeButtons = new JPanel();
        homeButtons.setLayout(new FlowLayout());
        
        homeButtons.add(Buttons.getButton("Ayuda", ButtonSize.LARGE));
        homeButtons.add(Buttons.getButton("Cerrar Sesión", ButtonSize.LARGE));
       
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridBagLayout());
        
        homePanel.add(welcomePanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;

        welcomePanel.add(dateLabel, gbc);
        
        JPanel logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(LogoSize.LARGE));
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        welcomePanel.add(logoPanel, gbc);
        

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

    public JPanel getHomeContent() {
        return welcomePanel;
    }


}
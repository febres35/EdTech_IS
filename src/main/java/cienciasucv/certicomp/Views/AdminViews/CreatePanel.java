package cienciasucv.certicomp.Views.AdminViews;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

import java.awt.*;

public class CreatePanel extends JPanel {
    CreatePanel(){
    }

    public static class LimitedTextField extends JTextField {
        private final int maxLength;
        public LimitedTextField(int maxLength) {
            this.maxLength = maxLength;
          
            final int finalMaxLength = maxLength; // Declara final variable para su uso en clase interna
    
            ((AbstractDocument) getDocument()).setDocumentFilter(new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                    if ((fb.getDocument().getLength() + string.length()) <= finalMaxLength) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
    
                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if ((fb.getDocument().getLength() + text.length() - length) <= finalMaxLength) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            });
        }
    }
    
    public void addSideText(String content,int x, int y, int w, int h){
        JLabel cont = new JLabel(content);
        cont.setBounds(x,y, w, h);
        cont.setForeground(Color.BLACK);
        cont.setBackground(Color.lightGray);
        cont.setFont(new Font("MyriadPro", Font.PLAIN, 13));
        this.add(cont);
    }

    public static JTextField addTextBox(int x, int y, int w, int h){
        JTextField AreaDeTexto = new JTextField();
        AreaDeTexto.setBounds(x, y, w, h);
        return AreaDeTexto;
    }
    
    public static JComboBox addComboBox(Object contenido[],int x,int y, int w, int h){
        JComboBox lista = new JComboBox(contenido);
        lista.setBounds(x, y, w, h);
        return lista;
    }
  
    public static JTextArea addTextArea(int x, int y, int w, int h){
        JTextArea Area = new JTextArea();
        Area.setBounds(x,y,w,h);
        Area.setFont(new Font("MyriadPro",Font.BOLD, 14));
        return Area;
    }
   
    public static Color Fondo = new Color(238,237,238);
    
    public static JLabel addTitulo(String Contenido,int x,int y,int w,int h,int s){
        JLabel titulo = new JLabel(Contenido, SwingConstants.LEFT);
        titulo.setOpaque(true);
        titulo.setBounds(x,y, w, h);
        titulo.setForeground(Color.BLACK);
        titulo.setBackground(Fondo);
        titulo.setFont(new Font("Roboto Black", Font.PLAIN, s));
        return titulo;
    }
   
    public void addFrameInfo(String Contenido,int x,int y,int w,int h){
        JLabel Info= new JLabel(Contenido);
        Info.setBounds(x,y,w,h);
        Info.setForeground(Color.BLACK);
        Info.setFont(new Font("MyruadPro",Font.BOLD,13));
        this.add(Info);
    }

    public class IntegerDocumentFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        currentText += text;
        try {
            int value = Integer.parseInt(currentText);
            if (value >= 0 && value <= 180) {
                super.insertString(fb, offset, text, attr);
            }
        } catch (NumberFormatException e) {
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        currentText += text;
        try {
            int value = Integer.parseInt(currentText);
            if (value >= 0 && value <= 180) {
                super.replace(fb, offset, length, text, attrs);
            }
        } catch (NumberFormatException e) {
        }
    }
    }

    protected  void addLogo(LogoSize size, int x, int y){
        JLabel labelLogo= LogoFactory.getLogo(size);
        labelLogo.setBounds(x, y,(int)labelLogo.getPreferredSize().width,(int)labelLogo.getPreferredSize().height);
        add(labelLogo);
    }

    
}

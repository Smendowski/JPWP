import javax.swing.*;
import java.awt.*;

public class Zadanie1 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new GridBagLayout());

        //ustawienia wstępne dla lepszej wizualizacji
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.ipady = 10;
        c.ipadx = 10;

        JLabel label = new JLabel("jakiś tekst1");
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        f.add(label, c);
        JLabel label2 = new JLabel("ccc");
        label2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        f.add(label2, c);
        JLabel label3 = new JLabel("ddd");
        label3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        f.add(label3, c);

        JLabel label4 = new JLabel("aaa");
        label4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        f.add(label4, c);
        JLabel label5 = new JLabel("bbb");
        label5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        f.add(label5, c);
        JButton button = new JButton("button");
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        f.add(button, c);


        f.pack();
        f.setVisible(true);
    }
}

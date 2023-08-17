import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation {
    public static void operate(int key){
        JFileChooser filechooser=new JFileChooser();
        filechooser.showOpenDialog(null);
        File file=filechooser.getSelectedFile();
        // file inputstream
        try {
            FileInputStream fis=new FileInputStream(file);
            byte[] data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for (byte b:data){
                data[i]= (byte) (b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("Image Encryption");
        f.setSize(500,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.BOLD,25);
        //Creating Button
        JButton b=new JButton();
        b.setText("Encrypt your file");
        b.setFont(font);
        // creating textfield
        JTextField tf=new JTextField(10);
        tf.setFont(font);
        f.setLayout(new FlowLayout());
        b.addActionListener(e->{
            String text=tf.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
        f.add(b);
        f.add(tf);
        f.setVisible(true);
    }
}

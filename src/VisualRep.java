import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VisualRep extends JPanel {
	
	char[][] plane;
	
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int i,j;
    for (i=0;i<plane.length;i++){
    	for (j=0;j<plane[0].length;j++){
    		g.drawRect(i*100, j*100, 100, 100);
    	    switch(plane[i][j]){
    	   
    	    case 'X':
    	    	g.setColor(Color.black);
    	    	break;
    	    case 'M':
    	    	g.setColor(Color.blue);
    	    	break;
    	    case 'T':
    	    	g.setColor(Color.red);
    	    	break;
    	    default:
    	    	g.setColor(Color.white);
    	    	break;
    	    }
    	    
    	    g.fillRect(i*100, j*100, 100, 100);
    	    System.out.println("i = "+ i + " j = "+ j);
    	}
    }
    

  }
 
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("FillRect");
    frame.setSize(400, 400);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    VisualRep p = new VisualRep();
    p.plane = new char[3][3];
    p.plane[0][0] = 'X';
    p.plane[0][1] = 'X';
    p.plane[0][2] = 'O';
    p.plane[1][0] = 'X';
    p.plane[1][1] = 'O';
    p.plane[1][2] = 'X';
    p.plane[2][0] = 'T';
    p.plane[2][1] = 'X';
    p.plane[2][2] = 'T';
    contentPane.add(p);
 //System.out.println("first print");
    frame.setVisible(true);
    try {
        Thread.sleep(1000);
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }
    
    System.out.println("second print");
    p.plane[0][2] = 'T';
    frame.validate();
    frame.repaint();
  }
 
}
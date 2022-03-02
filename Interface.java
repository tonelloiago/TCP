import javax.swing.JOptionPane;

public class Interface {

	public static void main(String[] args) {
		
		String A, c;
		int x, y;
		
		A = JOptionPane.showInputDialog("Entre um numero: ");
		
		try {
			
			x = Integer.parseInt(A);		

			JOptionPane.showMessageDialog(null,x,"teste input",JOptionPane.INFORMATION_MESSAGE); 
			
		
		} catch (Exception e) {
			
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Invalid"); 
			
		}
		

	}

}

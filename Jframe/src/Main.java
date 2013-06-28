import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class Main extends JFrame {
	// メインメソッド
	public static void main(String[] args) {
		// 真っ白のウィンドウを表示するだけ
		Main mainFrame = new Main();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(360, 240);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	private static final long serialVersionUID = 1L;
	private JTextField NameField;
	private JTextField MessageField;
	private JButton btnNewButton;
	public JTable table;
	private DefaultTableModel tm;
	
	public Main() {
		setTitle("メッセージ");
		getContentPane().setLayout(new MigLayout("", "[480,grow][480,grow]", "[27.00][27.00][30.00][480,grow]"));

		JLabel Namelabel = new JLabel("名前：");
		getContentPane().add(Namelabel, "cell 0 0,alignx trailing");

		NameField = new JTextField();
		getContentPane().add(NameField, "cell 1 0,grow");
		NameField.setColumns(10);

		JLabel Messagelabel = new JLabel("メッセージ：");
		getContentPane().add(Messagelabel, "cell 0 1,alignx trailing");

		MessageField = new JTextField();
		getContentPane().add(MessageField, "cell 1 1,grow");
		MessageField.setColumns(10);

		//JTableの作り方
		//テーブルに設定する列名の作成
		String[] header = {"名前","メッセージ"};
		tm = new DefaultTableModel(header,0);

		btnNewButton = new JButton("～送信～");
		btnNewButton.setToolTipText("");
		getContentPane().add(btnNewButton, "cell 0 2 2 1,grow");
		//JTableの作成
		table = new JTable(tm);
		table.setPreferredSize(new Dimension (512,512));
		//作成したJTableにスクロール機能を設定
		JScrollPane scroll = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setToolTipText("");
		getContentPane().add(scroll, "cell 0 3 2 1,grow");

	}
}
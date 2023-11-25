package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_maSinhVien_Tim;
	public JTable table;
	public JTextField textField_id;
	public JTextField textField_hoVaTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public ButtonGroup jButtonGroup_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton jRadio_nam;
	public JRadioButton jRadio_nu;
	private JComboBox comboBox_queQuan_timKiem;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model= new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 588);
		
		// Actionlistner
		ActionListener ac =new QLSVController(this);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.addActionListener(ac);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(ac);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(ac);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(ac);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(ac);;
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(ac);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_queQuan = new JLabel("Quê quán");
		label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_queQuan.setBounds(10, 10, 71, 23);
		contentPane.add(label_queQuan);
		
		comboBox_queQuan_timKiem = new JComboBox();
		comboBox_queQuan_timKiem.addItem("");
		ArrayList<Tinh> listTinh= Tinh.getDSTinh();
		for(Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(78, 13, 91, 21);
		contentPane.add(comboBox_queQuan_timKiem);
		
		
		JLabel label_maThiSinh = new JLabel("Mã thí sinh");
		label_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_maThiSinh.setBounds(179, 10, 185, 23);
		contentPane.add(label_maThiSinh);
		
		textField_maSinhVien_Tim = new JTextField();
		textField_maSinhVien_Tim.setColumns(10);
		textField_maSinhVien_Tim.setBounds(253, 14, 111, 20);
		contentPane.add(textField_maSinhVien_Tim);
		
		JButton btnNewButton_Tim = new JButton("Tìm");
		btnNewButton_Tim.addActionListener(ac);
		btnNewButton_Tim.setBackground(new Color(192, 192, 192));
		btnNewButton_Tim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Tim.setBounds(420, 13, 71, 21);
		contentPane.add(btnNewButton_Tim);
		
		JButton btnNewButton_huyTim = new JButton("Hủy tìm");
		btnNewButton_huyTim.addActionListener(ac);
		btnNewButton_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_huyTim.setBackground(Color.LIGHT_GRAY);
		btnNewButton_huyTim.setBounds(501, 12, 71, 21);
		contentPane.add(btnNewButton_huyTim);
		///
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 52, 562, 2);
		contentPane.add(separator_1);
		
		JLabel label_danhSachThiSinh = new JLabel("Danh sách thí sinh:");
		label_danhSachThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_danhSachThiSinh.setBounds(10, 66, 159, 23);
		contentPane.add(label_danhSachThiSinh);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u00ED sinh", "H\u1ECD T\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", " Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m-1", "\u0110i\u1EC3m-2", "\u0110i\u1EC3m-3"
			}
		));
		table.setRowHeight(25);
		table.setColumnSelectionAllowed(true);

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 90, 562, 187);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 287, 562, 2);
		contentPane.add(separator_1_1);
		
		JLabel label_thongTinThiSinh = new JLabel("Thông tin thí sinh ");
		label_thongTinThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_thongTinThiSinh.setBounds(20, 305, 208, 23);
		contentPane.add(label_thongTinThiSinh);
		
		JLabel label_id = new JLabel("Mã thí sinh:");
		label_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_id.setBounds(10, 338, 94, 23);
		contentPane.add(label_id);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(114, 338, 125, 23);
		contentPane.add(textField_id);
		
		JLabel label_hoVaTen = new JLabel("Họ và tên:");
		label_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_hoVaTen.setBounds(10, 371, 76, 23);
		contentPane.add(label_hoVaTen);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setColumns(10);
		textField_hoVaTen.setBounds(114, 371, 125, 23);
		contentPane.add(textField_hoVaTen);
		
		JLabel label_queQuan_1 = new JLabel("Quê quán");
		label_queQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_queQuan_1.setBounds(10, 404, 94, 23);
		contentPane.add(label_queQuan_1);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(114, 404, 125, 23);
		contentPane.add(comboBox_queQuan);
		
		JLabel label_ngaySinh = new JLabel("Ngày sinh");
		label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_ngaySinh.setBounds(10, 437, 94, 23);
		contentPane.add(label_ngaySinh);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(114, 437, 125, 23);
		contentPane.add(textField_ngaySinh);
		
		JLabel label_gioiTinh = new JLabel("Giới tính");
		label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_gioiTinh.setBounds(305, 338, 94, 23);
		contentPane.add(label_gioiTinh);

		jRadio_nam = new JRadioButton("Nam");
		jRadio_nam.setBounds(401, 341, 52, 21);
		contentPane.add(jRadio_nam);
		
		jRadio_nu = new JRadioButton("Nữ");
		jRadio_nu.setBounds(482, 341, 52, 21);
		contentPane.add(jRadio_nu);
		
		jButtonGroup_gioiTinh = new ButtonGroup();
		jButtonGroup_gioiTinh.add(jRadio_nu);
		jButtonGroup_gioiTinh.add(jRadio_nam);
		
		JLabel label_mon1 = new JLabel("Môn 1");
		label_mon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_mon1.setBounds(305, 371, 94, 23);
		contentPane.add(label_mon1);
		
		textField_mon1 = new JTextField();
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(409, 371, 125, 23);
		contentPane.add(textField_mon1);
		
		JLabel label_mon2 = new JLabel("Môn 2");
		label_mon2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_mon2.setBounds(305, 404, 94, 23);
		contentPane.add(label_mon2);
		
		textField_mon2 = new JTextField();
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(409, 404, 125, 23);
		contentPane.add(textField_mon2);
		
		JLabel label_mon3 = new JLabel("Môn 3");
		label_mon3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_mon3.setBounds(305, 437, 94, 23);
		contentPane.add(label_mon3);
		
		textField_mon3 = new JTextField();
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(409, 437, 125, 23);
		contentPane.add(textField_mon3);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(ac);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_them.setBackground(new Color(192, 192, 192));
		btn_them.setBounds(20, 487, 95, 21);
		contentPane.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(ac);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_xoa.setBackground(Color.LIGHT_GRAY);
		btn_xoa.setBounds(125, 487, 76, 21);
		contentPane.add(btn_xoa);
		
		JButton btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.addActionListener(ac);
		btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_capNhat.setBackground(Color.LIGHT_GRAY);
		btn_capNhat.setBounds(211, 487, 116, 21);
		contentPane.add(btn_capNhat);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(ac);
		btn_luu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_luu.setBackground(Color.LIGHT_GRAY);
		btn_luu.setBounds(337, 487, 75, 21);
		contentPane.add(btn_luu);
		
		JButton btn_cancel = new JButton("Hủy bỏ");
		btn_cancel.addActionListener(ac);
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_cancel.setBackground(new Color(129, 222, 215));
		btn_cancel.setBounds(468, 487, 104, 21);
		contentPane.add(btn_cancel);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_id.setText("");
		textField_hoVaTen.setText("");
		textField_ngaySinh.setText("");
		textField_mon1.setText("");
		textField_mon2.setText("");
		textField_mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		jButtonGroup_gioiTinh.clearSelection();	
	}
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(
				new Object[] {
				ts.getMaThiSinh()+"",
				ts.getTenThiSinh(),
				ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),
				ts.isGioiTinh()?"Nam":"Nữ",
				ts.getDiemMon1(),
				ts.getDiemMon2(),
				ts.getDiemMon3()
				});
	}

	public void themhoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		// thêm mới 
		if(!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);	
			this.themThiSinhVaoTable(ts);
		}else {
			// cập nhật
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for(int i = 0;i<soLuongDong;i++) {
				String id = model_table.getValueAt(i, 0)+"";// lấy ra mã sinh viên ở dòng vủa chọn
				if(id.equals(ts.getMaThiSinh()+"")) {
					model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900), i, 3);
					model_table.setValueAt(ts.isGioiTinh()?"Nam":"Nữ"+"", i, 4);
					model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
					model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
					model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
					break;
				}
			}
		}
		
		
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		int maThiSinh=Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh=model_table.getValueAt(i_row, 1)+" ";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaysinh= model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh= new Date(s_ngaysinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh= textGioiTinh.equals("Nam");
		float diemMon1= Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2=  Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3=  Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		ThiSinh ts = new ThiSinh( maThiSinh,  tenThiSinh,  tinh,  ngaySinh,  gioiTinh,  diemMon1, diemMon2,  diemMon3);
		return ts;
		
	}

	public void hienTHiThongTinThiSinhDaChon() {
		ThiSinh ts= getThiSinhDangChon();
		
		this.textField_id.setText(ts.getMaThiSinh()+"");
		textField_hoVaTen.setText(ts.getTenThiSinh());
		String s_ngaySinh = (ts.getNgaySinh().getDate())+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		textField_ngaySinh.setText(s_ngaySinh);
		textField_mon1.setText(ts.getDiemMon1()+"");
		textField_mon2.setText(ts.getDiemMon2()+"");
		textField_mon3.setText(ts.getDiemMon3()+"");
		comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		if(ts.isGioiTinh()) {
			jRadio_nam.setSelected(true);
		}else {
			jRadio_nu.setSelected(true);
		}
		
	}

	public void thucHienXoa() {
		DefaultTableModel model_table= (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thí sinh đã chọn");
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts= getThiSinhDangChon();
			model_table.removeRow(i_row);
			this.model.delete(ts);
		}
	}

	public void thucHienThemThiSinh() {
		try {
			// get data
			int maThiSinh=Integer.valueOf(this.textField_id.getText());
			String tenThiSinh=this.textField_hoVaTen.getText();
			int queQuan=this.comboBox_queQuan.getSelectedIndex()-1;
			Tinh tinh  = Tinh.getTinhById(queQuan);
			Date ngaySinh= new Date(this.textField_ngaySinh.getText());
			boolean gioiTinh = true;
			if(this.jRadio_nam.isSelected()) {
				gioiTinh = true;
			}else if(this.jRadio_nu.isSelected()) {
				gioiTinh= false;
			}
			
			float diemMon1= Float.valueOf(this.textField_mon1.getText());
			float diemMon2=  Float.valueOf(this.textField_mon2.getText());
			float diemMon3=  Float.valueOf(this.textField_mon3.getText());
			
			ThiSinh ts = new ThiSinh( maThiSinh,  tenThiSinh,  tinh,  ngaySinh,  gioiTinh,  diemMon1, diemMon2,  diemMon3);
			this.themhoacCapNhatThiSinh(ts);	
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public void ThucHienTimKiem() {
		// thuchien huy tim kiem 
		this.ThucHienTaiLaiDuLieu();
		// thuc hien timf
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex()-1;
		String maThiSinhTimKiem = this.textField_maSinhVien_Tim.getText();
		DefaultTableModel model_table= (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer>IdCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan>=0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for(int i = 0;i<soLuongDong;i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";// lấy ra mã sinh viên ở dòng vủa chọn
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					IdCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}

		}
		if(maThiSinhTimKiem.length()>0) {
			for(int i= 0;i<soLuongDong;i++) {
				String maThiSinhTrongTable = model_table.getValueAt(i, 0)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if(!maThiSinhTrongTable.equals(maThiSinhTimKiem)) {
					IdCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for(Integer idCanXoa: IdCuaThiSinhCanXoa) {
			 soLuongDong = model_table.getRowCount();
			 for(int i= 0;i<soLuongDong;i++) {
					String idTrongTable= model_table.getValueAt(i, 0)+"";
					if(idTrongTable.equals(idCanXoa.toString())) {
						System.out.println("Daxoa"+i);
						try {
							model_table.removeRow(i);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						break;
					}
				}
		}
		
	}
	
	public void ThucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong ==0) {
				break;
			}else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		for (ThiSinh thiSinh:this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(thiSinh);
		}
		
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this,"Phần mềm quản lí thí sinh!");
	}

	public void thoatKhoiChuonTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this,
				"Bạn có muốn thoát khỏi chương trình này không!" , 
				"Information",
				JOptionPane.YES_NO_OPTION
				);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			for(ThiSinh thiSinh: this.model.getDsThiSinh()) {
				oos.writeObject(thiSinh);
			}
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
			
			
		}else {
			final JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal==JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				this.saveFile(file.getAbsolutePath());
			}
		}
	}
	public void OpenFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois =new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			
			ois.close();
		}catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
		
		
	}	
	public void thucHienOpenFile() {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	File file = fc.getSelectedFile();
		        this.OpenFile(file);
		        this.ThucHienTaiLaiDuLieu();
		    }
		}
	}


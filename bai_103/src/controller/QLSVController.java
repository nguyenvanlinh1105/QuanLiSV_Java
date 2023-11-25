package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener{
	QLSVView view;
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(view,"bạn vừa nhẩn vào: "+src);
		if(src.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		}else if(src.equals("Lưu")) {
			this.view.thucHienThemThiSinh();
		}else if(src.equals("Cập nhật")) {
			this.view.hienTHiThongTinThiSinhDaChon();
		}else if(src.equals("Xóa")) {
			this.view.thucHienXoa();
		}else if(src.equals("Hủy bỏ")) {
			this.view.xoaForm();
		}else if(src.equals("Tìm")) {
			this.view.ThucHienTimKiem();	
		}else if(src.equals("Hủy tìm")) {
			this.view.ThucHienTaiLaiDuLieu();
		}else if(src.equals("About me")) {
			this.view.hienThiAbout();
		}else if(src.equals("Exit")) {
			this.view.thoatKhoiChuonTrinh();
		}else if(src.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if(src.equals("Open")) {
			this.view.thucHienOpenFile();
		}
		
		
	}

}

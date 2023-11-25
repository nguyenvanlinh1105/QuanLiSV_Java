package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;
	private String tenFile;

	public QLSVModel() {
		this.dsThiSinh= new ArrayList<ThiSinh>();
		this.luaChon="";
		this.tenFile="";
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	// methob insert
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
	// delete methob
	public void delete(ThiSinh ts) {
		for(ThiSinh thiSinh :dsThiSinh) {
			if(thiSinh.getMaThiSinh()==ts.getMaThiSinh()) {
				this.dsThiSinh.remove(thiSinh);
				break;
			}
		}
	}
	// methob update 
	public void update (ThiSinh ts) {
		this.dsThiSinh.remove(ts);
		this.dsThiSinh.add(ts);
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for(ThiSinh thiSinh : dsThiSinh) {
			if(thiSinh.getMaThiSinh()==ts.getMaThiSinh()) {
				return true;
			}
		}
		return false;
	}
	
	
}

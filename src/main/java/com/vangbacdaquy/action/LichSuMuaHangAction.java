/**
 * 
 */
package com.vangbacdaquy.action;

import java.util.ArrayList;
import java.util.List;

import com.vangbacdaquy.dto.*;
import com.vangbacdaquy.dao.*;

/**
 * @author minhn
 *
 */
public class LichSuMuaHangAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maPMH;
	P_MuaHangDTO muaHangDTO;
	CTP_MuaHangDTO ctp_MuaHangDTO;

	P_MuaHangDAO muaHangDAO = new P_MuaHangDAO();
	CTP_MuaHangDAO ctp_MuaHangDAOO = new CTP_MuaHangDAO();
	
	
	public int getMaPMH() {
		return maPMH;
	}

	public void setMaPMH(int maPMH) {
		this.maPMH = maPMH;
	}

	@Override
	public void prepare() throws Exception {
		super.prepare();
	}

	@Override
	public String execute() throws Exception {
		return "success";
	}

	public String getAllPhieuMuaHang() {
		result.put("error", true);
		List<P_MuaHangDTO> listP_MuaHang = new ArrayList<P_MuaHangDTO>();
		try {
			listP_MuaHang = muaHangDAO.getAllP_MuaHang();
			result.put("error", false);
		} catch (Exception e) {
			result.put("error", true);
		}
		result.put("data", listP_MuaHang);
		return "json";
	}

	public String getCTPMuaHangByMaPMH() {
		result.put("error", true);
		List<CTP_MuaHangDTO> listCTP_MuaHang = new ArrayList<CTP_MuaHangDTO>();
		try {
			listCTP_MuaHang = ctp_MuaHangDAOO.getCTPMuaHangByMaPMH(maPMH);
			result.put("error", false);
		} catch (Exception e) {
			result.put("error", true);
		}
		result.put("data", listCTP_MuaHang);
		return "json";

	}
}

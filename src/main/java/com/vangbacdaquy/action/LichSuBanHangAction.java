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
public class LichSuBanHangAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maPBH;
	P_BanHangDTO mbanHangDTO;
	CTP_BanHangDTO ctp_BanHangDTO;

	P_BanHangDAO mbanHangDAO = new P_BanHangDAO();
	CTP_BanHangDAO ctp_BanHangDAOO = new CTP_BanHangDAO();

	public int getMaPBH() {
		return maPBH;
	}

	public void setMaPBH(int maPBH) {
		this.maPBH = maPBH;
	}

	@Override
	public void prepare() throws Exception {
		super.prepare();
	}

	@Override
	public String execute() throws Exception {
		return "success";
	}

	public String getAllPhieuBanHang() {
		result.put("error", true);
		List<P_ThuDTO> listP_BanHang = new ArrayList<P_ThuDTO>();
		try {
			listP_BanHang = mbanHangDAO.getAllP_BanHang();
			result.put("error", false);
		} catch (Exception e) {
			result.put("error", true);
		}
		result.put("data", listP_BanHang);
		return "json";
	}

	public String getCTPMuaHangByMaPBH() {
		result.put("error", true);
		List<CTP_BanHangDTO> listCTP_BanHang = new ArrayList<CTP_BanHangDTO>();
		try {
			listCTP_BanHang = ctp_BanHangDAOO.getCTPBanHangByMaPBH(maPBH);
			result.put("error", false);
		} catch (Exception e) {
			result.put("error", true);
		}
		result.put("data", listCTP_BanHang);
		return "json";

	}
}

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
public class LichSuDichVuAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maDV;
	P_DichVuDTO mbanHangDTO;
	CTP_DichVuDTO ctp_DichVuDTO;

	P_DichVuDAO mDichVuDAO = new P_DichVuDAO();
	CTP_DichVuDAO ctp_DichVuDAOO = new CTP_DichVuDAO();


	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	@Override
	public void prepare() throws Exception {
		super.prepare();
	}

	@Override
	public String execute() throws Exception {
		return "success";
	}

	public String getAllPhieuDichVu() {
		result.put("error", true);
		List<P_ThuDTO> listP_DichVu = new ArrayList<P_ThuDTO>();
		try {
			listP_DichVu = mDichVuDAO.getAllP_DichVu();
			result.put("error", false);
		} catch (Exception e) {
			result.put("error", true);
		}
		result.put("data", listP_DichVu);
		return "json";
	}

	public String getCTPMuaHangByMaPDV() {
		result.put("error", true);
		List<CTP_DichVuDTO> listCTP_DichVu = new ArrayList<CTP_DichVuDTO>();
		try {
			listCTP_DichVu = ctp_DichVuDAOO.getCTPDichVuByMaPBH(maDV);
			result.put("error", false);
		} catch (Exception e) {
			result.put("error", true);
		}
		result.put("data", listCTP_DichVu);
		return "json";

	}
}

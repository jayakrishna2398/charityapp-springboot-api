package com.revature.charityapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.revature.charityapp.model.FundRequest;

import exception.DBException;
@Repository
public class TransactionList {
	@Autowired
	private DataSource dataSource;
	public List<FundRequest> donorFundRequest() throws SQLException {
		
		Connection con = dataSource.getConnection();
		List<FundRequest> list = null;
		try {
			list = new ArrayList<FundRequest>();
			String sql =  "select request_type,target_amount,"
					+ " ifnull((select sum(amount_funded) from transaction_details where fund_id = fr.id),0) as fund_raised,"
					+ " ifnull(target_amount -(select sum(amount_funded) from transaction_details where fund_id = fr.id),0) as fund_p"
					+ " from fund_request fr";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			FundRequest request = null;
			while (rs.next()) {
				String reqType = rs.getString("request_type");
				Integer amount = rs.getInt("target_amount");
				Double fundRaised = rs.getDouble("fund_raised");
				Double fundPending = rs.getDouble("fund_p");
				request = new FundRequest();
				request.setReqType(reqType);
				request.setAmount(amount);
				request.setFundRaised(fundRaised);
				request.setFundPending(fundPending);
	
				list.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return list;

	}
}

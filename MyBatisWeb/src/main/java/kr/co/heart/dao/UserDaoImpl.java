package kr.co.heart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.heart.domain.User;



@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	DataSource ds;
	
	final int FAIL = 0;
	
	public User selectUser(String id) {
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from t_user where id = ? ";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString(1));
				user.setPwd(rs.getString(2));
			    user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setBirth(new Date(rs.getDate(5).getTime()));
				user.setSns(rs.getString(6));
				user.setReg_date(new Date(rs.getTimestamp(7).getTime()));
			}
			
		} catch (SQLException e) {
			return null;
		} finally {
/*			if(rs != null) {try {rs.close();} catch (SQLException e) { e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) { e.printStackTrace();}}
			if(conn != null) {try {conn.close();} catch (SQLException e) { e.printStackTrace();}}
*/		   
			close(rs, pstmt, conn);
		}
		return user;
	}

	@Override
	public void deleteAll() throws Exception {
		Connection conn = ds.getConnection();
		String sql = "delete from t_user";
		
		PreparedStatement pstmt = conn.prepareCall(sql);
		pstmt.executeUpdate();
		
	}

	@Override
	public int insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into t_user values (?,?,?,?,?,?,now())";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
		    pstmt.setString(2, user.getPwd());
		    pstmt.setString(3, user.getName());
		    pstmt.setString(4, user.getEmail());
		    pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
		    pstmt.setString(6, user.getSns());
		    return pstmt.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			return FAIL;
		} finally {
			close(pstmt, conn);
		}
		
	
	}

	private void close(AutoCloseable...closeables) {
		for (AutoCloseable autoCloseable : closeables) {
			try { if(autoCloseable != null ) autoCloseable.close();} catch (Exception e) {e.printStackTrace();}
		}
	}

	@Override
	public int UpdateUser(User user) {
		int rowCnt = FAIL;
		
		String sql = "update t_user " + 
		   		"set pwd = ? , name = ? , email = ? , birth = ? , sns = ? , reg_date = ? "+
		   		"where id = ? ";
		
		//try-with-resources
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			   pstmt.setString(1, user.getPwd());
			   pstmt.setString(2, user.getName());
			   pstmt.setString(3, user.getEmail());
			   pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
			   pstmt.setString(5, user.getSns());
			   pstmt.setTimestamp(6, new java.sql.Timestamp(user.getReg_date().getTime()));   
			   pstmt.setString(7, user.getId());
			
			   rowCnt = pstmt.executeUpdate();
			   
		} catch (SQLException e) {
			e.printStackTrace();
			return FAIL;
		}
		
		
		return rowCnt;
	}


}

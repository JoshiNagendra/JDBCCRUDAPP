package in.joshi.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.joshi.dto.Student;
import in.joshi.util.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {
    Connection connection = null;
	@Override
	public String save(Student student) {
		String status=null;
		PreparedStatement pstmnt = null;
		String insertQuery ="insert into students(`name`,`city`,`email`,`country`) values(?,?,?,?)";
		try {
			connection =JDBCUtil.getConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(insertQuery);
				if(pstmnt!=null) {
					pstmnt.setString(1,student.getName());
					pstmnt.setString(2,student.getCity());
					pstmnt.setString(3,student.getEmail());
					pstmnt.setString(4, student.getCountry());
					int rowsEffec = pstmnt.executeUpdate();
					if(rowsEffec==1) {
						status="sucess";
					}else {
						status="failure";
					}
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	} 

	@Override
	public Student findById(Integer sid) {
		String selectQuery ="select id,name,city,email,country from students where id=?";
		PreparedStatement pstmnt =null;
		ResultSet result = null;
		Student student=null;
		try {
			connection =JDBCUtil.getConnection();
			if(connection!=null) {
				pstmnt =connection.prepareStatement(selectQuery);
			if(pstmnt!=null) {
				pstmnt.setInt(1,sid);
				if(pstmnt!=null) {
					
					result=pstmnt.executeQuery();
					if(result.next()) {
						 student =new Student();
					
						student.setSid(result.getInt(1));
						student.setName(result.getString(2));
						student.setCity(result.getString(3));
						student.setEmail(result.getString(4));
						student.setCountry(result.getString(5));
						
					}
				}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		
		String status=null;
		PreparedStatement pstmnt = null;
		String insertQuery ="update students set name =?,city=?,email=?,country=? where id =?";
		try {
			connection =JDBCUtil.getConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(insertQuery);
				if(pstmnt!=null) {
					pstmnt.setString(1,student.getName());
					pstmnt.setString(2,student.getCity());
					pstmnt.setString(3,student.getEmail());
					pstmnt.setString(4, student.getCountry());
					pstmnt.setInt(5,student.getSid());
					int rowsEffec = pstmnt.executeUpdate();
					if(rowsEffec==1) {
						status="sucess";
					}else {
						status="failure";
					}
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	} 

	@Override
	public String deleteById(Integer sid) {
		String status=null;

		
		try {
			Student student =findById(sid);
			if(student!=null) {
				String deleteQuery ="delete from students where id = ?";
				PreparedStatement pstmnt =null;
				int result;
				
				try {
					connection =JDBCUtil.getConnection();
					if(connection!=null) {
						pstmnt =connection.prepareStatement(deleteQuery);
					if(pstmnt!=null) {
						pstmnt.setInt(1,sid);
						if(pstmnt!=null) {
							
							result=pstmnt.executeUpdate();
							if(result==1) {
								status="sucess";
							}
						}
					}
					}
				} catch (SQLException e) {
					status="failure";
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else {
				status="record not available";
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}

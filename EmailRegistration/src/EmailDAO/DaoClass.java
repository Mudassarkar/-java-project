package EmailDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Bean.EmailBean;


import EmailDBConnection.EmailDBConnection;
	
public class DaoClass implements DaoInterface {
	static Connection con=EmailDBConnection.getConnection();
	
	public int insert(EmailBean EB) {
	 int status = 0;
	try {
		PreparedStatement ps =con.prepareStatement("insert into emailtable(id,Email,password)values(?,?,?)");
		ps.setInt(1, EB.getId());
		ps.setString(2,EB.getEmail());
		ps.setString(3, EB.getPassword());
		status =ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
	finally
	{
	return status;
	}
	}

	public   ArrayList<EmailBean> viewtable()
	{
		ArrayList<EmailBean> AB = new ArrayList<EmailBean>();
		
		try {
			Statement stmnt  = con.createStatement();
			String View_Query= "Select * from emailtable";
			ResultSet rs=stmnt.executeQuery(View_Query);
			while(rs.next())
			{
				EmailBean EB = new EmailBean();
				EB.setId(rs.getInt("id"));
				EB.setEmail(rs.getString("Email"));
				EB.setPassword(rs.getString("Password"));
				AB.add(EB);	
			}
	
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return AB;
		}


	public  EmailBean getbyid(int id)
	{
	EmailBean EB=null; 
	
	try
	{
		System.out.println("@@@@@@@@@@@@@@@  BEFORE GETID  @@@@@@@@@@@@@@@@@@@@@@@@@@");
		PreparedStatement stmnt1=con.prepareStatement("Select * from emailtable where id=?");
		stmnt1.setInt(1, id);
		java.sql.ResultSet rs1=stmnt1.executeQuery();
		
		while(rs1.next())
		{
			EB=new EmailBean();
			EB.setId(rs1.getInt("id"));
			EB.setEmail(rs1.getString("Email"));
			EB.setPassword(rs1.getString("Password"));
		}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return EB;
		}

public int Update(EmailBean EB)
{
	int s=0;

	try
	{
		System.out.println("##############BEFORE UPDATE######################");
		PreparedStatement Stmnt2 =con.prepareStatement("update emailtable set Email=?,password=? where id=?");
		Stmnt2.setInt(3, EB.getId());
		Stmnt2.setString(1,EB.getEmail());
		Stmnt2.setString(2, EB.getPassword());
	
	s=Stmnt2.executeUpdate();
	System.out.println("##########After Update#################");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
System.out.println(s);
	return s;
	
	}

public int delete(int id)
{
	int i=0;
	try {
		PreparedStatement ps=con.prepareStatement("Delete from emailtable where id=?");
		ps.setInt(1, id);
		i=ps.executeUpdate();
		
		}
	catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return i;
}
}

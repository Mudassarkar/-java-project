package EmailDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.Bean.EmailBean;



public interface DaoInterface {
	 
	int insert(EmailBean EB);
	public ArrayList<EmailBean> viewtable();
    public  EmailBean getbyid(int id);
    public int Update(EmailBean EB);
    public int delete(int id);

}

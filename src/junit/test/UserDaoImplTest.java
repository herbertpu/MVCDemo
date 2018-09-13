package junit.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import com.login.dao.IUserDao;
import com.login.dao.impl.UserDaoImpl;
import com.login.domain.User;
import com.login.util.XmlUtils;

import java.util.Date;

class UserDaoImplTest {

    @Test
    void find() {
        try {
            Document document = XmlUtils.getDocument();
            String xPath = "users";
            Element element = (Element) document.selectSingleNode(xPath);
            if (element != null){
                System.out.println("T");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void find1() {
        IUserDao dao = new UserDaoImpl();
        System.out.println(dao.find("adsad"));
    }

    @Test
    void add() {
        User user = new User();
        user.setBirthday(new Date());
        user.setEmail("");
        user.setId("2132354354");
        user.setUserName("bebb");
        user.setUserPwd("123");

        IUserDao dao = new UserDaoImpl();
        dao.add(user);
    }
}
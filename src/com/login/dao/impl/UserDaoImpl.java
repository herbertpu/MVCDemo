package com.login.dao.impl;

import org.dom4j.Document;
import org.dom4j.Element;

import com.login.dao.IUserDao;
import com.login.domain.User;
import com.login.util.XmlUtils;

import java.text.SimpleDateFormat;

/**
 * 数据访问层
 * 存放访问数据库的操作接口的实现类
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User find(String userName, String userPwd) {
        try {
            Document document = XmlUtils.getDocument();
            //使用XPath表达式来操作XML节点
            String xPath = "//user[@userName='" + userName + "' and @userPwd='" + userPwd + "']";
            Element e = (Element) document.selectSingleNode(xPath);
            if (e == null){
                return null;
            }

            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setEmail(e.attributeValue("email"));
            user.setUserName(e.attributeValue("userName"));
            user.setUserPwd(e.attributeValue("userPwd"));
            String birth = e.attributeValue("birthday");
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            user.setBirthday(simpleDateFormat.parse(birth));
            if(birth == null || birth.equals("")) {
                user.setBirthday(null);
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                user.setBirthday(df.parse(birth));
            }

            return user;
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public User find(String userName) {
        try {
            Document document = XmlUtils.getDocument();
            //使用XPath表达式来操作XML节点
            String xPath = "//user[@userName = '"+ userName +"']";
            Element e = (Element) document.selectSingleNode(xPath);
            if (e == null){
                return null;
            }

            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setEmail(e.attributeValue("email"));
            user.setUserName(e.attributeValue("userName"));
            user.setUserPwd(e.attributeValue("userPwd"));
            String birth = e.attributeValue("birthday");
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            user.setBirthday(simpleDateFormat.parse(birth));
            if(birth == null || birth.equals("")) {
                user.setBirthday(null);
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                user.setBirthday(df.parse(birth));
            }

            return user;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void add(User user) {
        try {
            Document document = XmlUtils.getDocument();
            Element root = document.getRootElement();
            Element user_node = root.addElement("user");//创建user结点，并挂到root

            user_node.addAttribute("id", user.getId());
            user_node.addAttribute("userName", user.getUserName());
            user_node.addAttribute("userPwd", user.getUserPwd());
            user_node.addAttribute("email", user.getEmail());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            user_node.addAttribute("birthday", user.getBirthday()==null?"":sdf.format(user.getBirthday()));
            /*root.addElement("user").addAttribute("id", user.getId())
                .addAttribute("username", user.getUserName())
                .addAttribute("password", user.getUserPwd())
                .addAttribute("email", user.getEmail())
                .addAttribute("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());*/

            XmlUtils.write2Xml(document);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

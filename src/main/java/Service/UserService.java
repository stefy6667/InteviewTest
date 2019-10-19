package Service;

import Model.User;
import Model.UserW;
import Util.HibernateUtil;


import org.hibernate.Session;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


import java.io.File;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
public class UserService {
    public static UserService instance = new UserService();

    public static UserService getInstance() {
        return instance;
    }

    public void createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        //HibernateUtil.shutdown();
    }



    public List<User> GetX(int x) {
        String query = "";
        if(x > 0){
            query= "from x where id ="+x;
        }else {
            query = "from x";
        }

        org.hibernate.Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        Serializer serializer = new Persister();

        UserW users =new UserW();
        File result1 = new File("/home/andrei/GeomantTest/src/main/resources/example.xml");
        List<User> result =  session2.createQuery(query).list();
        users.setUser(result);

        try {
            serializer.write(users,result1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        session2.getTransaction().commit();
       // HibernateUtil.shutdown();

        return result;
    }


}

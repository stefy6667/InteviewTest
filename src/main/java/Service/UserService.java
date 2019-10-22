package Service;

import Model.User;
import Model.UserW;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.List;

@SuppressWarnings("ALL")
public class UserService {
    public static UserService instance = new UserService();
    private Query query1;

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
        Configuration configuration = new Configuration().addResource("user.hbl.xml");
        configuration.configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sf = configuration.buildSessionFactory(sr);

        Session session = sf.openSession();

        session.beginTransaction();



           query1 =  session.getNamedQuery("GetX").setParameter("IdX",x);

//          UserW userW = new UserW();
//        userW.setUser(query1.list());
//
//        List result = userW.getUser();
        Serializer serializer = new Persister();



        UserW users =new UserW();
        File result1 = new File("/home/andrei/Desktop/InteviewTest/src/main/resources/example.xml");
        List<User> result = query1.list();
        users.setUser(result);

        try {
            serializer.write(users,result1);
        } catch (Exception e) {
            e.printStackTrace();
        }






        return result;
    }


}

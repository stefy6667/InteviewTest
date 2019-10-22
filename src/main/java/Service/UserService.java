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


        if (x > 0) {
            query1 = session.getNamedQuery("findViaUserID").setString("id", String.valueOf(x));

        } else {
           query1 =  session.getNamedQuery("findAllUser");

        }

        List<User> user =query1.list();




        return user;
    }


}

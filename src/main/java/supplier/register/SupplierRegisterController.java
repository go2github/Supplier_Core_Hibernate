package supplier.register;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import supplier.entity.Supplier;
import supplier.util.HibernateUtil;

@RestController
public class SupplierRegisterController {

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    Long saveSupplier(@RequestBody Supplier supplier){

        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Long sid= (Long) session.save(supplier);
        session.getTransaction().commit();
        sessionFactory.close();
        return sid;
    }

}

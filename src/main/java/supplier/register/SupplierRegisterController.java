package supplier.register;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.*;
import supplier.entity.Supplier;
import supplier.util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
public class SupplierRegisterController {

    @RequestMapping(value = "/supplier/register",method = RequestMethod.POST)
    Long saveSupplier(@RequestBody Supplier supplier){

        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Long sid= (Long) session.save(supplier);
        session.getTransaction().commit();
        sessionFactory.close();
        return sid;
    }
    @RequestMapping(value = "/supplier",method = RequestMethod.GET)
    List<Supplier> getAllSupplier(){

        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query= session.createQuery("select s FROM Supplier s");
        return query.getResultList();

    }

    @RequestMapping(value = "/supplier/{id}",method = RequestMethod.GET)
    Supplier getSupplierById(@PathVariable Long id){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();



        Query query=session.createNamedQuery("Supplier_By_Id",Supplier.class);
        query.setParameter("id",id);
        Supplier sid= (Supplier) query.getSingleResult();

        return sid;

    }
    @RequestMapping(value = "/supplier/info",method = RequestMethod.GET)
    Supplier getSupplierByIDorName(@RequestParam(defaultValue = "") String name ,@RequestParam(required = true) Long id){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Supplier> query = builder.createQuery(Supplier.class);

        Root<Supplier> root = query.from(Supplier.class);

        query.select(root).where(builder.equal(root.get("supplier_Id"), id));

        if(!name.equalsIgnoreCase("")){
            query.where(builder.equal(root.get("company_name"),name));
        }
        Query q1 = session.createQuery(query);
        return (Supplier) q1.getSingleResult();

    }


}

package jpajava;

import jpajava.domain.Address;
import jpajava.domain.Person;
import jpajava.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        final Session session = HibernateUtil.getSessionFactory().openSession();
        final Transaction trx = session.getTransaction();

        try {
            trx.begin();
            //savePerson(session);
            getPerson(session, 1L);
            trx.commit();
        } catch (HibernateException e) {
            if (trx != null) {
                trx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        HibernateUtil.shutdown();
    }

    private static void savePerson(final Session session){
        Address homeAddress = new Address("Molukkenstraat", "Den haag", "1000");
        Address billingAddress = new Address("Witte de wit straat", "Rotterdam", "1000");
        Person person = new Person("Ahmed", homeAddress, billingAddress);
        session.save(person);
    }

    private static void getPerson(final Session session, long personId){
        Person person = (Person) session.get(Person.class, personId);
        System.out.println(person);
    }
}

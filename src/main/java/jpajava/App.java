package jpajava;


import jpajava.domain.Message;
import jpajava.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        final Session session = HibernateUtil.getSessionFactory().openSession();
        final Transaction trx = session.beginTransaction();

        try {
            trx.begin();
//            saveMessage(session,"Hello Basma from Hibernate");
            updateMessage(session, 2L, "Hello from nowhere");
//            deleteMessage(session, trx, 27L);
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

    private static void saveMessage(final Session session, final String msg) {
        Message message = new Message(msg);
        session.save(message);
    }

    private static void updateMessage(final Session session, final long messageId, final String msg) {
        Message message = (Message) session.get(Message.class, messageId);
        message.setText(msg);
    }

    private static void deleteMessage(final Session session, final long messageId) {
        Message message = (Message) session.get(Message.class, messageId);
        session.delete(message);
    }
}

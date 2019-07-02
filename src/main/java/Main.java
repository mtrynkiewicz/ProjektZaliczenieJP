import Logic.Entity.Employees;
import Logic.Entity.Proffesions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;
import java.util.TimeZone;

public class Main
{
    public static void main(String[] args)
    {
        //get Calendar instance
        Calendar now = Calendar.getInstance();

        //get current TimeZone using getTimeZone method of Calendar class
        TimeZone timeZone = now.getTimeZone();

        //display current TimeZone using getDisplayName() method of TimeZone class
        System.out.println("Current TimeZone is : " + timeZone.getDisplayName());

        int z1=3;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .addAnnotatedClass(Proffesions.class)
                .buildSessionFactory();
        int z2=4;
// tworzymy sesje:
        Session session = factory.getCurrentSession();


        Employees emp1 = new Employees();
        emp1.setName("Czesław");
        emp1.setSurname("Czesany");
        emp1.setRating(0.0);
        emp1.setTotalIncome(0.0);

        session.beginTransaction();

        Proffesions prof1 = session.get(Proffesions.class,1);
        System.out.println("Czesiek Czesany: "+prof1.getProffesionName());

        prof1.addEmployee(emp1);
        session.save(emp1);

        Employees emp2 = session.get(Employees.class,1);

        session.delete(emp2);

        session.getTransaction().commit();

        session.close();

        factory.close();
        int z =3;
    }
}

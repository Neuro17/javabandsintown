package main;

import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Artist;

import DAO.ArtistDAO;
  
public class SpringHibernateMain {
 
    public static void main(String[] args) {
 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
         
        ArtistDAO personDAO = context.getBean(ArtistDAO.class);
         
        Artist person = new Artist("preparati a sucare la minchia","69");
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
//        List<Artist> list = personDAO.list();
//         
//        for(Artist p : list){
//            System.out.println("Person List::"+p);
//        }
        //close resources
        context.close();    
    }
}
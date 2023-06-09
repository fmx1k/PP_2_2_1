package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "lastName1", "lastname1@gmail.com");
      User user2 = new User("User2", "lastName2", "lastname2@gmail.com");
      User user3 = new User("User3", "lastName3", "lastname3@gmail.com");
      User user4 = new User("User4", "lastName4", "lastname4@gmail.com");

      Car car = new Car("Ford", 3000);
      Car car2 = new Car("Lamborghini", 1000);
      Car car3 = new Car("Mercedes", 2000);
      Car car4 = new Car("Fiat", 4000);

      user1.setCar(car);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      System.out.println(userService.takeUserFromCar("Ford", 3000));
      System.out.println(userService.takeUserFromCar("Lamborghini", 1000));
      System.out.println(userService.takeUserFromCar("Mercedes", 2000));
      System.out.println(userService.takeUserFromCar("Fiat", 4000));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = " + user.getCar().getModel());
         System.out.println("Car series = " + user.getCar().getSeries());
         System.out.println("Car Id = " + user.getCar().getId());
         System.out.println();
      }

      context.close();
   }
}

package utils;


import entities.Item;
import entities.Recipe;
import entities.Role;
import entities.Storage;
import entities.User;
import entities.Ingredient;
import entities.WeeklyMenuPlanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User user = new User("chef", "test1");
    User admin = new User("admin", "test2");
    User both = new User("user_admin", "test3");
    
    Item item1 = new Item("Spagetti", 1000);
    Item item2 = new Item("Bacon", 16000);
    Item item3 = new Item("Pesto", 9000);
    Item item4 = new Item("Basil", 100000);
    Storage storage1 = new Storage(10, item1);
    Storage storage2 = new Storage(20, item2);
    Storage storage3 = new Storage(30, item3);
    Storage storage4 = new Storage(40, item4);
    
    item1.setItemId(storage1);
    item2.setItemId(storage2);
    item3.setItemId(storage3);
    item4.setItemId(storage4);
    List<Item> items = new ArrayList();
    items.add(item1);
    items.add(item2);
    items.add(item3);
    items.add(item4);
    
    Ingredient ing1 = new Ingredient(5, item1);
    Ingredient ing2 = new Ingredient(10, item2);
    Ingredient ing3 = new Ingredient(15, item3);
    Ingredient ing4 = new Ingredient(20, item4);
    
    List<Ingredient> ingredients = new ArrayList();
    ingredients.add(ing1);
    ingredients.add(ing2);
    ingredients.add(ing3);
    ingredients.add(ing4);
    
    Recipe recipe1 = new Recipe(1000, "Bare lav det.", ingredients);
    Recipe recipe2 = new Recipe(2000, "Bare lav det.", ingredients);
    Recipe recipe3 = new Recipe(3000, "Bare lav det.", ingredients);
    Recipe recipe4 = new Recipe(4000, "Bare lav det.", ingredients);
    Recipe recipe5 = new Recipe(5000, "Bare lav det.", ingredients);
    Recipe recipe6 = new Recipe(6000, "Bare lav det.", ingredients);
    Recipe recipe7 = new Recipe(7000, "Bare lav det.", ingredients);
    
    List<Recipe> recipes = new ArrayList();
    recipes.add(recipe1);
    recipes.add(recipe2);
    recipes.add(recipe3);
    recipes.add(recipe4);
    recipes.add(recipe5);
    recipes.add(recipe6);
    recipes.add(recipe7);
    
    WeeklyMenuPlanner wmp1 = new WeeklyMenuPlanner(new Date(), new Date(), recipes);
    WeeklyMenuPlanner wmp2 = new WeeklyMenuPlanner(new Date(), new Date(), recipes);
  //  Ingredient ing1 = new Ingredient();

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("chef");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.persist(item1);
    em.persist(item2);
    em.persist(item3);
    em.persist(item4);
    em.persist(storage1);
    em.persist(storage2);
    em.persist(storage3);
    em.persist(storage4);
    em.persist(ing1);
    em.persist(ing2);
    em.persist(ing3);
    em.persist(ing4);
    em.persist(recipe1);
    em.persist(recipe2);
    em.persist(recipe3);
    em.persist(recipe4);
    em.persist(recipe5);
    em.persist(recipe6);
    em.persist(recipe7);
    em.persist(wmp1);
    em.persist(wmp2);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    
  }

}

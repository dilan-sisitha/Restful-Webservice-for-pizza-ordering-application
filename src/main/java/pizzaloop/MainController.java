package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private UserRepositary userRepositary;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    private static final String SUCCESS = "Saved";

    @GetMapping(path = "/userdata")
    public @ResponseBody
    Iterable<User> UserDetails() {
        User user = new User();
        return userRepositary.findAll();
    }


    /*
     * READ Operation
     * This method will list all the pizzas in the table
     * URI to access this: http://localhost:8080/demo/all
     */

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<PizzaDetails> getPizzaDetails() {

        PizzaDetails pizzaDetails = new PizzaDetails();
        return pizzaRepository.findAll();


    }
    @GetMapping(path = "/allcart")
    public @ResponseBody
    Iterable<Cart> getCartDetails() {

        Cart cart = new Cart();
        return cartRepository.findAll();


    }
    @GetMapping(path = "/login")
    public @ResponseBody
    Iterable<LoginDetails> getLoginDetails() {

        LoginDetails pizzaDetails = new LoginDetails();
        return loginDetailsRepository.findAll();


    }

    private static int Status =0;
    @GetMapping(path = "/checkUser")
    public @ResponseBody
    int adduser(@RequestParam String password, @RequestParam String email) {



        List<User> users = userRepositary.findByEmail(email);
        if (!users.isEmpty()) {
            for (User u : users) {
                String pass = u.getPassword();
                if(pass.equals(password)){
                    Status = 1;

                }
                else {
                    Status = 0;
                }

            }
        }
        else {
            Status = 0;
        }

        return Status;
    }

    /*
     * READ Operation based on Pizza ID
     * This method will return the details of a pizza specified by the id
     * URI to access this: http://localhost:8080/demo/findByPizzaId?id=2
     */
    @GetMapping(path = "/findByPizzaId")
    public @ResponseBody
    List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }

    /*
     * CREATE Operation
     * This method will crate new pizza item in the database table
     * and returns the SUCCESS message
     * URI to access this: http://localhost:8080/demo/add?name=VegiPizza&description=VegiSupreme&price=2500.75
     */
    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewPizza(@RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;

    }

    @GetMapping(path = "/useradd")
    public @ResponseBody
    String adduser(@RequestParam String user_name, @RequestParam String password, @RequestParam String email, @RequestParam String telephone) {
        User username = new User();
        username.setUser_name(user_name);
        username.setPassword(password);
        username.setEmail(email);
        username.setTelephone(telephone);

        userRepositary.save(username);
        return SUCCESS;
    }

    @GetMapping(path = "/addlogin")
    public @ResponseBody
    String addlogin(@RequestParam String email) {
        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setEmail(email);


        loginDetailsRepository.save(loginDetails);
        return SUCCESS;
    }


    @GetMapping(path = "/addcart")
    public @ResponseBody
    String addNeCart(@RequestParam String pizza_type, @RequestParam String quantity, @RequestParam Double price) {
        Cart cartdetails = new Cart();
        cartdetails.setPizza_type(pizza_type);
        cartdetails.setQuantity(quantity);
        cartdetails.setPrice(price);


        cartRepository.save(cartdetails);
        return SUCCESS;

    }

    /*
     * DELETE Operation
     * This method will delete existing pizza item by finding it using the ID
     * and returns the deleted item
     * URI to access this: http://localhost:8080/demo/deleteByPizzaId?id=2
     */
    @GetMapping(path = "/deleteByPizzaId")
    public @ResponseBody
    List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);


    }

    /*
     * UPDATE Operation
     * This method will update existing pizza details by finding it using the ID
     * and returns the updated data
     * URI to access this: http://localhost:8080/demo/update?id=1&name=updatedname&description=updated&price=1234.56
     */
    @GetMapping(path = "/update")
    public @ResponseBody
    List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        //First get all the pizza details according to the provided ID
        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if (!pizzaDetailsList.isEmpty()) {
            //Iterate through the pizza list
            for (PizzaDetails pizzaDetails : pizzaDetailsList) {
                //Set new values
                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);
                //Update existing pizza item
                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }


}

package Data;

import org.testng.annotations.DataProvider;

public class TestData {

    //register sucessfully
    //dublicate email
    //empty fields
    static String Email = "tester10test1@gmail.com";


    //Register Page
    @DataProvider(name = "registerData")
    public static Object[][] userData(){
        return new Object[][]{
                //(first name, last name, email, password, condition)
                {"ahmed","diaa",Email,"success"},
                {"ahmed","diaa",Email,"Test121!@","duplicate"},
                {"ahmed","","geehe21@gmail.com","Test121!@","error"}
        };
    }

    //Login Page
    @DataProvider(name = "LoginData")
    public static Object[][] LoginData(){
        return new Object[][]{
                //(email, password, condition)
                {Email,"Test121!@","success"},
                {"teshfghfghfgh@gmail.com","Test121!@","NotRegistered"},
                {"test","Test121!@","invalidemail"},
                {"","","error"}
        };
    }

    //Forgot password Page
    @DataProvider(name = "forgotPass")
    public static Object[][] forgotPass(){
        return new Object[][]{
                //(email, condition)
                {Email,"success"},
                {"", "empty"},
                {"test", "invalidemail"},
        };
    }

    @DataProvider(name = "wishlistlogin")
    public static Object[][] wishlistlogin(){
        return new Object[][]{
                //(email, password)
                {Email,"Test121!@"}
        };
    }

}

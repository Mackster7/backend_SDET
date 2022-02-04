import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunnerTest {
    @BeforeTest
    void setup(){
        System.out.println("Setting your account");
    }

    @Test(priority = 1)
    void login(){
        System.out.println("logging in to account");
    }

    @Test(priority = 2)
    void shopping(){
        System.out.println("purchasing item from a platform");
    }

    @Test(priority =3)
    void payments(){
        System.out.println("making payment and confirming the order");
    }

    @AfterTest
    void logout(){
        System.out.println("sigining off");
    }
}

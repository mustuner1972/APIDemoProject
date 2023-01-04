package files;

public class messageHelper {
    public static void main(String[] args) {

        Message me = new Message();
        me.setMessage("Hello");
        me.setGreet("Hi");
        System.out.println("me.getMessage() = " + me.getMessage());
        System.out.println("me.getGreet() = " + me.getGreet());
    }
}


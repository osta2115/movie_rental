package action_strategy;

public class Commons {
    private static final Commons INSTANCE = new Commons();

    private Commons() {
    }

    public static Commons getInstance() {
        return INSTANCE;
    }

    public static void exitShop() {
        System.out.println("Come back soon !");
        System.exit(3);
    }
}
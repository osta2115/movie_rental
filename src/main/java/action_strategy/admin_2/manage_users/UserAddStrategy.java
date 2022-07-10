package action_strategy.admin_2.manage_users;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import tables.Client;

public class UserAddStrategy implements Strategy {
    @Override
    public void algorithm() {
        try {
            Client client = new Client();
            System.out.println("Adding new user");
            System.out.println("<------------------------------------------->");
            System.out.println("Enter first name:");
            client.setFirstName(MyScanner.getText());
            System.out.println("Enter last name:");
            client.setLastName(MyScanner.getText());

            do {
                System.out.println("Enter phone number:");
                client.setPhoneNumber(MyScanner.getText());
                if (!Client.isPhoneNumberCorrect(client.getPhoneNumber())){
                    System.out.println("Wrong phone number. Try again.");
                }
            } while (!Client.isPhoneNumberCorrect(client.getPhoneNumber()));

            do {
                System.out.println("Enter email:");
                client.setEmail(MyScanner.getText());
                if (!Client.isEmailCorrect(client.getEmail())){
                    System.out.println("Wrong email. Try again.");
                }
            } while (!Client.isEmailCorrect(client.getEmail()));

            do {
                System.out.println("Enter postal code:");
                client.setPostalCode(MyScanner.getText());
                if (!Client.isPostalCodeCorrect(client.getPostalCode())){
                    System.out.println("Wrong postal code. Try again.");
                }
            } while (!Client.isPostalCodeCorrect(client.getPostalCode()));

            System.out.println("Enter address:");
            client.setAddress(MyScanner.getText());

            do {
                System.out.println("Enter login:");
                client.setLogin(MyScanner.getText());
                if (Client.isLoginCorrect(client.getLogin())){
                    System.out.println("Wrong login. Try again.");
                }
            } while (Client.isLoginCorrect(client.getLogin()));

            do {
                System.out.println("Enter password:");
                client.setPassword(MyScanner.getText());
                if (!Client.isPasswordCorrect(client.getPassword())){
                    System.out.println("Wrong password. Try again.");
                }
            } while (!Client.isPasswordCorrect(client.getPassword()));

            System.out.println("Is it admin? Type 0 or 1:");
            client.setAdmin(MyScanner.getInt());

            if (client.getAdmin() > 1 || client.getAdmin() < 0) {
                client.setAdmin(0);
            }

            StrategyCommons.getClientsRepositoryHibernate().createClient(client);
            System.out.println("New client added");
            MyScanner.pressAnyKeyToContinue();
            new ManageUsersLogic().startAdminUserManagementPanel();
        } catch (Exception e) {
            System.out.println("Something want wrong, try again");
            new ManageUsersLogic().startAdminUserManagementPanel();
        }
    }
}

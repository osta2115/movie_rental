package hibernate;

import tables.Client;

public interface ClientsRepository {

    boolean createClient(Client client);

    boolean deleteClientById(Integer id);



    boolean changeClientFirstName(Integer id, String newName);

    boolean changeClientLastName(Integer id, String newLastName);

    boolean changeClientPhone(Integer id, String newPhone);

    boolean changeClientEmail (Integer id, String newEmail);

    boolean changeClientPostalCode (Integer id, String postalCode);

    boolean changeClientAddress (Integer id, String newAdress);

    boolean changeClientPassword (Integer id, String password);

    boolean giveAdmin(Integer id);



    Client authorization(String login, String password);
}

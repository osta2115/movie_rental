package hibernate;

import tables.Client;

import java.util.Optional;

public interface ClientsRepository {

    Optional<ClientBasicInfo> getClientBasicInfoById(int id);

    Optional<Client> getClientById(int id);

    void createClient(Client client);

    void deleteClientById(Integer id);

    void changeClientFirstName(Integer id, String newName);

    void changeClientLastName(Integer id, String newLastName);

    void changeClientPhone(Integer id, String newPhone);

    void changeClientEmail (Integer id, String newEmail);

    void changeClientPostalCode (Integer id, String postalCode);

    void changeClientAddress (Integer id, String newAddress);

    void changeClientPassword (Integer id, String password);

    void giveAdmin(Integer id);

    Client authorization(String login, String password);
}

package hibernate;

import tables.Client;

import java.sql.SQLException;
import java.util.Optional;

public interface ClientsRepository {

    Optional<ClientBasicInfo> getClientBasicInfoById(int id) throws SQLException;

    void createClient(Client client) throws SQLException;

    void deleteClientById(Integer id) throws SQLException;

    void changeClientFirstName(Integer id, String newName) throws SQLException;

    void changeClientLastName(Integer id, String newLastName) throws SQLException;

    void changeClientPhone(Integer id, String newPhone) throws SQLException;

    void changeClientEmail (Integer id, String newEmail) throws SQLException;

    void changeClientPostalCode (Integer id, String postalCode) throws SQLException;

    void changeClientAddress (Integer id, String newAdress) throws SQLException;

    void changeClientPassword (Integer id, String password) throws SQLException;

    void giveAdmin(Integer id) throws SQLException;

    Client authorization(String login, String password) throws SQLException;
}

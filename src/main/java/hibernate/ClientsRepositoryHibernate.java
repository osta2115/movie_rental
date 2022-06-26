package hibernate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tables.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
public class ClientsRepositoryHibernate implements ClientsRepository{

    private final EntityManager entityManager;

    @Override
    public void createClient(Client client) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteClientById(Integer id) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToRemove = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToRemove, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            entityManager.remove(client);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientFirstName(Integer id, String newName) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setFirstName(newName);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update first name for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientLastName(Integer id, String newLastName) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setLastName(newLastName);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update last name for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientPhone(Integer id, String newPhoneNumber) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setPhoneNumber(newPhoneNumber);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update phone number for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientEmail(Integer id, String newEmail) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setEmail(newEmail);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update email for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientPostalCode(Integer id, String newPostalCode) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setPostalCode(newPostalCode);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update postal code for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientAddress(Integer id, String newAddress) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setAddress(newAddress);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update address for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientPassword(Integer id, String newPassword) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            TypedQuery query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = (Client) query.getSingleResult();
            client.setPassword(newPassword);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update password for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public boolean giveAdmin(Integer id) throws SQLException {
        return false;
    }

    @Override
    public Client authorization(String login, String password) throws SQLException {
        return null;
    }
}

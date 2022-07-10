package hibernate;

import action_strategy.StrategyCommons;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tables.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ClientsRepositoryHibernate implements ClientsRepository{

    private final EntityManager entityManager;

    @Override
    public Optional<ClientBasicInfo> getClientBasicInfoById(int id) {
        String selectClientBasicInfoById = """
                select new hibernate.ClientBasicInfo(c.id, c.login, c.firstName, c.lastName)
                from Client c
                where c.id = :id
                """;
        var query = entityManager.createQuery(selectClientBasicInfoById, ClientBasicInfo.class);
        query.setParameter("id", id);

        try {
            var clientBasicInfo = query.getSingleResult();
            return Optional.of(clientBasicInfo);
        } catch (NoResultException e) {
            log.warn("Could not find Client by provided id: {}", id);
            return Optional.empty();
        }
    }
    @Override
    public Optional<Client> getClientById(int id) {
        try {
            String selectClientBasicInfoById = """
                select c
                from Client c
                where c.id = :id
                """;
        var query = entityManager.createQuery(selectClientBasicInfoById, Client.class);
        query.setParameter("id", id);
        var result = query.getSingleResult();
        return Optional.of(result);
        } catch (NoResultException e) {
            log.warn("Could not find Client by provided id: {}", id);
            return Optional.empty();
        }
    }

    @Override
    public void createClient(Client client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e){

        }
    }

    @Override
    public void deleteClientById(Integer id) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToRemove = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToRemove, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            entityManager.remove(client);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientFirstName(Integer id, String newName) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setFirstName(newName);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update first name for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientLastName(Integer id, String newLastName) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setLastName(newLastName);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update last name for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientPhone(Integer id, String newPhoneNumber) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setPhoneNumber(newPhoneNumber);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update phone number for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientEmail(Integer id, String newEmail) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setEmail(newEmail);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update email for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientPostalCode(Integer id, String newPostalCode) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setPostalCode(newPostalCode);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update postal code for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientAddress(Integer id, String newAddress) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setAddress(newAddress);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update address for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void changeClientPassword(Integer id, String newPassword) {
        try {
            entityManager.getTransaction().begin();
            String selectClientToChangeFirstName = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectClientToChangeFirstName, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            client.setPassword(newPassword);
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot update password for non-existing client. Client id: {}", id);
        }
    }

    @Override
    public void giveAdmin(Integer id) {
        try {
            entityManager.getTransaction().begin();
            String selectUserToGiveAdmin = "select c from Client c where c.id = :id";
            var query = entityManager.createQuery(selectUserToGiveAdmin, Client.class);
            query.setParameter("id", id);
            Client client = query.getSingleResult();
            if (client.getAdmin() == 0) {
                client.setAdmin(1);
            } else {
                log.warn("User with id: {} is already an admin", id);
            }
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot give admin permissions to non-existing user. User id: {}", id);
        }
    }

    public Client authorization(String login, String password) {
        try {
            entityManager.getTransaction().begin();
            String selectUserByLogin = "select c from Client c where c.login = :login";
            var query = entityManager.createQuery(selectUserByLogin, Client.class);
            query.setParameter("login", login);
            Client client = query.getSingleResult();
            if (client.getPassword().equals(password)){
                log.info("User {} logged in", login);
                entityManager.getTransaction().commit();
                return client;
            } else {
                log.warn("Wrong login or password");
            }
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            log.warn("Cannot check authorization for non-existing user");
        }
        return null;
    }
}

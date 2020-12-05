package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import pl.javastart.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClientDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Client save(Client client) {
        entityManager.persist(client);
        return client;
    }

    public Client read(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Transactional
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    @Transactional
    public void delete(Client client) {
        Client attachedClient = read(client.getId());
        entityManager.remove(attachedClient);
    }
}

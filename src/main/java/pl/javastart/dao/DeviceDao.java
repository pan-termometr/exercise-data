package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import pl.javastart.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DeviceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Device save(Device device) {
        entityManager.persist(device);
        return device;
    }

    public Device read(Long id) {
        return entityManager.find(Device.class, id);
    }

    @Transactional
    public Device update(Device device) {
        return entityManager.merge(device);
    }

    @Transactional
    public void delete(Device device) {
        Device attachedDevice = read(device.getId());
        entityManager.remove(attachedDevice);
    }
}
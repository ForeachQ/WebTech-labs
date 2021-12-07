package com.company.service;

import com.company.exception.RepositoryException;
import com.company.exception.ServiceException;
import com.company.repository.creator.RepositoryCreator;
import com.company.repository.impl.RoomRepository;
import com.company.entity.Room;
import com.company.specification.common.FindById;
import com.company.specification.room.FindAll;
import com.company.specification.room.FindFree;

import java.util.List;
import java.util.Optional;

public class RoomService {

    public List<Room> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<Room> findFree() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindFree());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void saveRoom(Integer id, String roomNumber, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, occupied);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void changeStatus(Integer id, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Optional<Room> room = roomRepository.query(new FindById(id));
            if (room.isPresent()) {
                room.get().setOccupied(occupied);
                roomRepository.save(room.get());
            } else {
                throw new ServiceException("No such room id");
            }
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}

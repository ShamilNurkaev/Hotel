package ru.kpfu.itis.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.hotel.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM user_hotel WHERE email = :email")
    void deleteByEmail(String email);

/*
    @Query(nativeQuery = true, value = "UPDATE user_hotel " +
            "SET firstName = :first_name, lastName = :lastName, email = :email, roomsId = :rooms_id " +
            "WHERE id = :id")
    void update(User entity);
*/

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE user_hotel " +
            "SET first_name = :newFirstName, last_name = :newLastName WHERE email = :email")
    void updateFirstNameAndLastNameByEmail(@Param("newFirstName") String newFirstName,
                                           @Param("newLastName") String newLastName,
                                           @Param("email") String email);

    @Query(nativeQuery = true, value = "SELECT * FROM user_hotel WHERE email = :email")
    Optional<User> findOneByEmail(@Param("email") String email);

    /*@Transactional
    @Modifying
    @Query("UPDATE User SET state = 'BANNED' WHERE email = :email")
    void banByEmail(@Param("email") String email);*/

    /*@Transactional
    @Modifying
    @Query("UPDATE User SET state = 'ACTIVE' WHERE email = :email")
    void unbanByEmail(@Param("email") String email);*/

    /*@Query(nativeQuery = true, value =
            "INSERT INTO account (first_name, last_name, state) " +
                    "VALUES (:firstName, :lastName, 'ACTIVE') " +
                    "RETURNING id")
    Long saveUserWithReturningId(@Param("firstName") String firstName,
                                 @Param("lastName") String lastName);*/
}

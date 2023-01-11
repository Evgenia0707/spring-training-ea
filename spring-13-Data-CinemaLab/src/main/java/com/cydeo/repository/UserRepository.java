package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?

    Optional<User> findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?

    List<User> findAllByUsernameContains(String name);
    List<User> findAllByAccountNameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    List<User> findAllByUsernameContainsIgnoreCase(String pattern);
    List<User> findAllByAccountNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?

    List<User> findByAccountAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    List<User> fetchUserByEmailJPQL(@Param("email") String email);

    //Write a JPQL query that returns a user read by username?

    @Query("SELECT u FROM User u where u.username = ?1")
    List<User> fetchUserByUserNameJPQL(@Param("username") String username);

    //Write a JPQL query that returns all users?

    @Query("SELECT u FROM User u")
    List<User>  fetchAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(value = "SELECT * FROM user_account u " +
            "JOIN acoount_details ad ON ad.id = u.account_details_id" +
            "WHERE ad.name ILIKE concat ('%', ?1, '%')", nativeQuery = true)// table name = user
    List<Movie> retrieveAllUsersThatContainSpecificName(@Param("name") String name);

    //Write a native query that returns all users?

    @Query(value = "SELECT * FROM userAccount", nativeQuery = true)
    List<User> retrieveAllUsers();

    //Write a native query that returns all users in the range of ages?

    @Query(value = "SELECT * FROM userAccount u " +
            "JOIN accountDetails ad ON ad.id = u.accountDetailsId" +
            "WHERE ad.age BETWEEN ?1q AND ?2", nativeQuery = true)
    List<User> retrieveUserBetweenAgeRange(@Param("age1") Integer age1, @Param("age2") Integer age2);

    //Write a native query to read a user by email?

    @Query(value = "SELECT * FROM userAccount WHERE email = ?1", nativeQuery = true)
    User retrieveUserByEmail(@Param("email") String email);

}
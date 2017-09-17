package ru.zolotarev.portfolio.repository;

import com.salimov.yurii.entity.User;

/**
 * The interface provides a set of JPA methods
 * for working {@link User} objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 * @see DataRepository
 * @see User
 */
public interface UserRepository extends DataRepository<User> {

    /**
     * Returns user from a database,
     * which matches the parameter login.
     *
     * @param login a login of the user to return.
     * @return The object of class {@link User}.
     * @see User
     */
    User findByEncryptedLogin(final String login);

    /**
     * Returns user from a database,
     * which matches the parameter url.
     *
     * @param url a url of the user to return.
     * @return The object of class {@link User}.
     * @see User
     */
    User findByUrl(final String url);

    /**
     * Removes user from a database,
     * which matches the parameter login.
     *
     * @param login a login of the user to remove.
     * @see User
     */
    void deleteByEncryptedLogin(final String login);

    /**
     * Removes user from a database,
     * which matches the parameter url.
     *
     * @param url a url of the user to remove.
     * @see User
     */
    void deleteByUrl(final String url);
}

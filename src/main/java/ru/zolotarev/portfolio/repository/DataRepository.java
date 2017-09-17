package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zolotarev.portfolio.model.Model;

/**
 * The interface provides a set of standard JPA methods
 * for working objects which extends {@link Model} with a database.
 *
 * @param <T>  Entity type, extends {@link Model}.
 * @see UserRepository
 * @see Model
 */
public interface DataRepository<T extends Model> extends JpaRepository<T, Long> {
}

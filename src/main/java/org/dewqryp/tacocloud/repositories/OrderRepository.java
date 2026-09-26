package org.dewqryp.tacocloud.repositories;

import org.dewqryp.tacocloud.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}

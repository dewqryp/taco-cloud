package org.dewqryp.tacocloud.repositories;

import org.dewqryp.tacocloud.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder,String> {

}

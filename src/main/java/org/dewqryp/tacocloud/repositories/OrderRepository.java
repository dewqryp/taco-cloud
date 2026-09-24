package org.dewqryp.tacocloud.repositories;

import org.dewqryp.tacocloud.data.TacoOrder;

public interface OrderRepository {
    TacoOrder saveOrder(TacoOrder order);
}

package org.dewqryp.tacocloud.messaging;

import org.dewqryp.tacocloud.data.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}

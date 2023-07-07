package com.portfolio.orderservice.service;

import com.portfolio.orderservice.dto.OrderLineItemsDto;
import com.portfolio.orderservice.dto.OrderRequest;
import com.portfolio.orderservice.model.Order;
import com.portfolio.orderservice.model.OrderLineItems;
import com.portfolio.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public  void placeOrder(OrderRequest orderRequest)
    {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

      List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
      order.setOrderLineItemsList(orderLineItems);
      orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

}

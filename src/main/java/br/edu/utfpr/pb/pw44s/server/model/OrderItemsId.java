package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderItemsId implements Serializable {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof OrderItemsId)) return false;
        OrderItemsId that = (OrderItemsId) o;
        return Objects.equals(getOrderId(), that.getOrderId()) && Objects.equals(getProductId(), that.getProductId());
    }

    public int hashCode(){
        return Objects.hash(getOrderId(), getProductId());
    }

}

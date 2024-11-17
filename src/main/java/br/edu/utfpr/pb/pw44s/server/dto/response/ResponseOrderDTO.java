package br.edu.utfpr.pb.pw44s.server.dto.response;

import br.edu.utfpr.pb.pw44s.server.dto.OrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class ResponseOrderDTO {
        //private User user;

        private Address address;

        private Date orderDate;

        private String payment;

        private String shipping;

        private List<OrderItemsDTO> ItemsList;
}

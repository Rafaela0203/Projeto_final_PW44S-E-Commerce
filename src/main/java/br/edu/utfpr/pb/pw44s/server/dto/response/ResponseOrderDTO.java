package br.edu.utfpr.pb.pw44s.server.dto.response;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data

public class ResponseOrderDTO {
        private Long id;

        private Address address;

        private LocalDateTime orderDate;

        private String payment;

        private BigDecimal shipping;

        private BigDecimal total;

        private List<ResponseOrderItemsDTO> itemsList;
}

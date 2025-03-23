package com.pos.system.dto.responsedto.paginated;

import com.pos.system.dto.responsedto.ResponseCustomerDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedCustomerDto {
    private long count;
    private List<ResponseCustomerDto> dataList;
}

package com.pos.system.dto.responsedto.paginated;

import com.pos.system.dto.responsedto.ResponseOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedOrderDTO {
    private long count;
    private List<ResponseOrderDto> dataList;
}

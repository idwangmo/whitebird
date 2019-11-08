package top.idwangmo.authservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.idwangmo.authservice.entity.Client;
import top.idwangmo.authservice.model.request.ClientRequest;
import top.idwangmo.authservice.model.response.ClientResponse;

/**
 * Client Mapper.
 *
 * @author idwangmo
 */
@Mapper
public interface ClientMapper {
    ClientMapper CLIENT_MAPPER = Mappers.getMapper(ClientMapper.class);

    /**
     * 将实体类转换成返回请求.
     *
     * @param client 实体类
     * @return 返回请求
     */
    ClientResponse toResponse(Client client);

    /**
     * 将请求转换为实体类.
     *
     * @param clientRequest 请求
     * @return 实体类
     */
    Client toClient(ClientRequest clientRequest);

}

package top.idwangmo.authservice.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.idwangmo.authservice.model.ClientModel;

/**
 * 应用返回.
 *
 * @author idwangmo
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClientResponse extends ClientModel {

    private Long id;
}

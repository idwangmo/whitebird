package top.idwangmo.whitebird.authservice.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.idwangmo.whitebird.authservice.model.ClientModel;

/**
 * Client Request.
 *
 * @author idwangmo
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClientRequest extends ClientModel {

    private String clientSecret;

}

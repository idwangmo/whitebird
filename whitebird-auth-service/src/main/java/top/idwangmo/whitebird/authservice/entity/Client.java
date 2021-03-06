package top.idwangmo.whitebird.authservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.idwangmo.whitebird.jpaspringbootstarter.model.BaseEntity;

import javax.persistence.Entity;

/**
 * Client 的配置.
 *
 * @author idwangmo
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Client extends BaseEntity {

    private String clientId;

    private String clientName;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes = "authorization_code,password,refresh_token,client_credentials";

    private String authorities = "";

    /**
     * token 的失效时间
     */
    private Integer accessTokenValiditySeconds = 60 * 60 * 2;

    /**
     * refresh token 失效时间
     */
    private Integer refreshTokenValiditySeconds = 60 * 60 * 24 * 30;

    private String webServerRedirectUri;

    private boolean autoApprove = false;

}

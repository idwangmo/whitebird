package top.idwangmo.whitebird.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 限流过滤器.
 *
 * @author idwangmo
 */
public class WhitebirdRateLimitFilter implements KeyResolver {

    public static final String BEAN_NAME = "whitebirdRateLimiter";

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono
            .just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}
package top.idwangmo.authservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.idwangmo.whitebird.commoncore.annotation.CurrentUser;
import top.idwangmo.whitebird.commoncore.model.WhitebirdUser;

/**
 * user controller.
 *
 * @author idwangmo
 */
@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("current")
    public ResponseEntity<?> resource(@CurrentUser WhitebirdUser principal) {
        log.info("查寻了下token");
        return ResponseEntity.ok(principal);
    }

}

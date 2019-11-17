package com.fandou.springboot.vhr.common;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fandou.springboot.vhr.model.Hr;

/**
 * Created by sang on 2017/12/30.
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

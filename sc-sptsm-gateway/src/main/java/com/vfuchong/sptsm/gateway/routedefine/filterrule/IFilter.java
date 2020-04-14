package com.vfuchong.sptsm.gateway.routedefine.filterrule;

import com.vfuchong.sptsm.gateway.routedefine.predicaterule.RuleCheck;
/**
 * ************************************
 * create by Intellij IDEA
 *
 * @author Francis.zz
 * @date 2020-03-27 16:22
 * ************************************
 */
public interface IFilter extends RuleCheck, GetFilter {
    @Override
    default boolean validate() {
        return true;
    }
}

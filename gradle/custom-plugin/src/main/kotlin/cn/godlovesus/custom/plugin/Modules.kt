@file:JvmName("ModulesKt")
package cn.godlovesus.custom.plugin
import cn.godlovesus.custom.plugin.ModulePaths as P
/**
 * <p>
 * 模块名称
 * </p>
 *
 * @author Song Tao
 */
object ModulePaths {

    const val projectName = "moreandmore"

    // common-core
    const val common_core = ":${projectName}-common-core"
    const val common_mq_core = ":${projectName}-common-mq-core"
    const val common_redis_core = ":${projectName}-common-redis-core"
    const val common_web_core = ":${projectName}-common-web-core"
    const val common_mongo_core = ":${projectName}-common-mongo-core"

    // common-base
    const val common_base = ":${projectName}-common-base"
    const val common_service_base = ":${projectName}-common-service-base"
    const val common_web_base = ":${projectName}-common-web-base"
    const val common_dubbo_base = ":${projectName}-common-dubbo-base"
    const val common_spring_base = ":${projectName}-common-spring-base"
    const val common_gateway_base = ":${projectName}-common-gateway-base"


    // global
    const val global_log_config = ":${projectName}-global-log-config"

    // domain-base
    const val domain_base_explorer = ":${projectName}-domain-base-explorer"

    // domain-auth
    const val domain_auth_core = ":${projectName}-domain-auth-core"
    const val domain_auth_client = ":${projectName}-domain-auth-client"

    // domain-purchase
    const val domain_purchase_core = ":${projectName}-domain-purchase-core"
    const val domain_purchase_client = ":${projectName}-domain-purchase-client"

    // domain-compliance
    const val domain_compliance_core = ":${projectName}-domain-compliance-core"
    const val domain_compliance_client = ":${projectName}-domain-compliance-client"

    fun ModuleDependencyHandler.common_core(){
        api(P.common_core)
    }
    fun ModuleDependencyHandler.common_mq_core(){
        api(P.common_mq_core)
    }
    fun ModuleDependencyHandler.common_redis_core(){
        api(P.common_redis_core)
    }
    fun ModuleDependencyHandler.common_web_core(){
        api(P.common_web_core)
    }
    fun ModuleDependencyHandler.common_mongo_core(){
        api(P.common_mongo_core)
    }

    // common-base
    fun ModuleDependencyHandler.common_base(){
        api(P.common_base)
    }
    fun ModuleDependencyHandler.common_service_base(){
        api(P.common_service_base)
    }
    fun ModuleDependencyHandler.common_web_base(){
        api(P.common_web_base)
    }
    fun ModuleDependencyHandler.common_dubbo_base(){
        api(P.common_dubbo_base)
    }
    fun ModuleDependencyHandler.common_spring_base(){
        api(P.common_spring_base)
    }
    fun ModuleDependencyHandler.common_gateway_base(){
        api(P.common_gateway_base)
    }


    // global
    fun ModuleDependencyHandler.global_log_config(){
        api(P.global_log_config)
    }

    // domain-base
    fun ModuleDependencyHandler.domain_base_explorer(){
        api(P.domain_base_explorer)
    }

    // domain-auth
    fun ModuleDependencyHandler.domain_auth_core(){
        api(P.domain_auth_core)
    }
    fun ModuleDependencyHandler.domain_auth_client(){
        api(P.domain_auth_client)
    }

    // domain-purchase
    fun ModuleDependencyHandler.domain_purchase_core(){
        api(P.domain_purchase_core)
    }
    fun ModuleDependencyHandler.domain_purchase_client(){
        api(P.domain_purchase_client)
    }

    // domain-compliance
    fun ModuleDependencyHandler.domain_compliance_core(){
        api(P.domain_compliance_core)
    }
    fun ModuleDependencyHandler.domain_compliance_client(){
        api(P.domain_compliance_client)
    }

}
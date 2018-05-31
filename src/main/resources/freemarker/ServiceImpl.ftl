package ${service_impl_package};

import ${dao_package}.${entity_name}Dao;
import ${entity_package}.${entity_name};
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class ${entity_name}ServiceImpl extends BaseServiceImpl<${entity_name}> implements ${entity_name}Service {

    @Resource
    private ${entity_name}Dao ${lower_entity_name}Dao;


    @Override
    protected BaseDao<${entity_name}> getRepository() {
        return ${lower_entity_name}Dao;
    }
    }
package xyz.lihang.blog.service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lihang.blog.common.tool.utils.BeanUpdateUtils;
import xyz.lihang.blog.common.tool.utils.UUIDUtils;
import xyz.lihang.blog.mapper.dao.FrendLinkMapper;
import xyz.lihang.blog.mapper.entity.FrendLink;
import xyz.lihang.blog.service.service.IFrendLinkService;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by LiHang on 2017/8/6.
 */
@Service
public class FrendLinkService extends BaseService<FrendLink> implements IFrendLinkService {

    private FrendLinkMapper frendLinkMapper;

    @Resource
    public void setFrendLinkMapper(FrendLinkMapper frendLinkMapper) {
        this.frendLinkMapper = frendLinkMapper;
        super.setBaseMapper(frendLinkMapper);
    }


    @Override
    @Transactional
    public int insert(FrendLink frendLink) {
        if(frendLink == null){
            frendLink = new FrendLink();
        }
        frendLink.setCreatetime(new Date());
        frendLink.setId(UUIDUtils.getUUID());
        frendLink.setVersion(0);
        return super.insert(frendLink);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(FrendLink frendLink) {
        FrendLink temp = selectByPrimaryKey(frendLink.getId());
        temp = (FrendLink) BeanUpdateUtils.objClone(temp, frendLink);
        temp.setVersion(temp.getVersion() + 1);
        return super.updateByPrimaryKey(temp);
    }
}

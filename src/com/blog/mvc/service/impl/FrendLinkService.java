package com.blog.mvc.service.impl;

import com.blog.mvc.dao.FrendLinkMapper;
import com.blog.mvc.entity.FrendLink;
import com.blog.mvc.service.IFrendLinkService;
import com.blog.mvc.utils.BeanUpdateUtils;
import com.blog.mvc.utils.UUIDUtils;
import org.springframework.stereotype.Service;

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
    public int updateByPrimaryKey(FrendLink frendLink) {
        FrendLink temp = selectByPrimaryKey(frendLink.getId());
        temp = (FrendLink) BeanUpdateUtils.objClone(temp, frendLink);
        temp.setVersion(temp.getVersion() + 1);
        return super.updateByPrimaryKey(temp);
    }
}

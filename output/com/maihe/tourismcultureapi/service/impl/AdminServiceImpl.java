package com.maihe.tourismcultureapi.service.impl;

import com.maihe.tourismcultureapi.model.Admin;
import com.maihe.tourismcultureapi.mapper.AdminMapper;
import com.maihe.tourismcultureapi.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author jiangli
 * @since 2020-07-29
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}

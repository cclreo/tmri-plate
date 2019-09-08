package com.tmri.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmri.user.entity.Test;
import com.tmri.user.mapper.TestMapper;
import com.tmri.user.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceimpl extends ServiceImpl<TestMapper,Test> implements TestService {
}

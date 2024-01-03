package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Demo Mapper
 *
 * @author fenglin
 * @since 2023-01-11 20:14:53
 */
@Mapper
@Repository
public interface DemoMapper extends BaseMapper<Demo> {
}

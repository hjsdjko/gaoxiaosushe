package com.dao;

import com.entity.FangwuRuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuRuzhuView;

/**
 * 公寓学生 Dao 接口
 *
 * @author 
 */
public interface FangwuRuzhuDao extends BaseMapper<FangwuRuzhuEntity> {

   List<FangwuRuzhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

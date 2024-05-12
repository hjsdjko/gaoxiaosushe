package com.dao;

import com.entity.FangwuTuisuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuTuisuView;

/**
 * 公寓退宿申请 Dao 接口
 *
 * @author 
 */
public interface FangwuTuisuDao extends BaseMapper<FangwuTuisuEntity> {

   List<FangwuTuisuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

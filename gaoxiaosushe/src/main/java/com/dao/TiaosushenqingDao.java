package com.dao;

import com.entity.TiaosushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TiaosushenqingView;

/**
 * 调宿申请 Dao 接口
 *
 * @author 
 */
public interface TiaosushenqingDao extends BaseMapper<TiaosushenqingEntity> {

   List<TiaosushenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

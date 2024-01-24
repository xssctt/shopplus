package com.example.mapper;

import com.example.dto.CardDto;
import com.example.entity.Card;
import com.example.entity.CardCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Mapper
public interface CardCategoryMapper extends BaseMapper<CardCategory> {


    @Insert("insert into cardandcategory(cardid,cardCategoryid,memberid,status) values (#{cardid},#{cardCategoryid},#{memberid},#{status})")
    Boolean insertCardidAndCategory(@Param("cardid") Integer cardid,@Param("cardCategoryid") Integer cardCategoryid,@Param("memberid") Integer memberid,@Param("status") Integer status);



    @Select("<script>" +
            " select * " +
            "from member a join card b " +
            "on a.id_card = b.number" +
            "<where>" +
            " <if test=' memberId != null and memberId != \" \" ' > " +
            "and a.id = #{memberId}" +
            "</if>"+
            " <if test=' status != null and status != 0 and status != \" \" ' > " +
            "and b.status = #{status}" +
            "</if>"+
            "</where >"+
            "</script> ")
    List<Card> listCard(@Param("memberId") Integer memberId, @Param("status") Integer status);


}

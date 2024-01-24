package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Consume;
import com.example.entity.ConsumeInfo;
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
public interface ConsumeInfoMapper extends BaseMapper<ConsumeInfo> {


//
//    @Select("<script>" +
//            " select count(*) from consume_info " +
//            "<where>" +
//            " <if test=' billId != null and billId != \" \" ' > " +
//            "and billId = #{billid}" +
//            "</if>"+
//            " <if test=' status != null and status != 0 and status != \" \" ' > " +
//            "and status = #{status}" +
//            "</if>"+
//            " <if test=' paymentStatus != null and status != 0 and status != \" \" ' > " +
//            "and status = #{status}" +
//            "</if>"+
//            " <if test=' status != null and status != 0 and status != \" \" ' > " +
//            "and status = #{status}" +
//            "</if>"+
//            "</where >"+
//            "</script> ")
//    Integer selectAllByIdAndNameAndStatus(@Param("billid") Integer billid,@Param("status") Integer status,@Param("paymentStatus") Integer paymentStatus,@Param("processStatus") Integer processStatus);


//    @Select("<script>" +
//            " select * from consume_info " +
//            "<where>" +
//            " <if test=' categoryId != null and categoryId != \" \" ' > " +
//            "and categoryId = #{categoryId}" +
//            "</if>"+
//            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
//            "and name = #{name}" +
//            "</if>"+
//            " <if test=' status != null and status != \" \" ' > " +
//            "and status = #{status}" +
//            "</if>"+
//            "</where >"+
//            "limit #{alimit} offset #{aoffset}"+
//            "</script> ")
//    List<ConsumeInfo> selectAllByIdAndNameAndStatuspage(@Param("status") Integer status, @Param("alimit") Integer alimit, @Param("aoffset") Integer aoffset);
//


// SELECT count(*) FROM consume_info
//        <where>
//            <if test=' billId != null and billId != "" '>
//                AND bill_id = #{billId}
//            </if>
//            <if test=' status != null and status != 0 and status != "" '>
//                AND status = #{status}
//            </if>
//            <if test=' processStatus != null and processStatus != 0 and processStatus != "" '>
//                AND process_status = #{processStatus}
//            </if>
//            <if test=' paymentStatus != null and paymentStatus.size() > 0 '>
//                AND payment_status IN
//                <foreach collection="paymentStatus" item="id" open="(" separator="," close=")">
//                    #{id}
//                </foreach>
//            </if>
//        </where>
@Select("<script>" +
        " select count(*) from consume_info " +
        "<where>" +
        " <if test=' status != null and status != 0 and status != \" \" ' > " +
        "and status = #{status}" +
        "</if>"+
        " <if test=' processStatus != null and processStatus != 0 and processStatus != \" \" ' > " +
        "and process_status = #{processStatus}" +
        "</if>"+
        " <if test=' billId != null and billId.size() > 0 '> " +
        " AND bill_id IN" +
        "<foreach collection='billId' item='ids' open='(' separator=',' close=')' >"+
        " #{ids}"+
        " </foreach>"+
        "</if>"+
        " <if test=' paymentStatus != null and paymentStatus.size() > 0 '> " +
        " AND payment_status IN" +
        "<foreach collection='paymentStatus' item='id' open='(' separator=',' close=')' >"+
        " #{id}"+
        " </foreach>"+
        "</if>"+
        "</where >"+
        "</script> ")
    Integer selectAllByAllStatus(@Param("billId") List<Integer> billId,
                                 @Param("status") Integer status,
                                 @Param("paymentStatus") List<Integer> paymentStatus,
                                 @Param("processStatus") Integer processStatus);

    @Select("<script>" +
            " select * from consume_info " +
            "<where>" +
            " <if test=' status != null and status != 0 and status != \" \" ' > " +
            "and status = #{status}" +
            "</if>"+
            " <if test=' processStatus != null and processStatus != 0 and processStatus != \" \" ' > " +
            "and process_status = #{processStatus}" +
            "</if>"+
            " <if test=' billId != null and billId.size() > 0 '> " +
            " AND bill_id IN" +
            "<foreach collection='billId' item='ids' open='(' separator=',' close=')' >"+
            " #{ids}"+
            " </foreach>"+
            "</if>"+
            " <if test=' paymentStatus != null and paymentStatus.size() > 0 '> " +
            " AND payment_status IN" +
            "<foreach collection='paymentStatus' item='id' open='(' separator=',' close=')' >"+
            " #{id}"+
            " </foreach>"+
            "</if>"+
            "</where >"+
            "limit #{alimit} offset #{aoffset}"+
            "</script> ")
    List<ConsumeInfo> selectAllByIdAndNameAndStatuspage(@Param("billId") List<Integer> billId,
                                                        @Param("status") Integer status,
                                                        @Param("paymentStatus") List<Integer> paymentStatus,
                                                        @Param("processStatus") Integer processStatus,
                                                        @Param("alimit") Integer alimit,
                                                        @Param("aoffset") Integer aoffset);


}

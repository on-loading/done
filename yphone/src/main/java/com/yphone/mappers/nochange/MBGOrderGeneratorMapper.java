package com.yphone.mappers.nochange;

import com.yphone.model.nochange.OrderGenerator;
import com.yphone.model.nochange.OrderGeneratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MBGOrderGeneratorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int countByExample(OrderGeneratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int deleteByExample(OrderGeneratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long orderGeneratorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int insert(OrderGenerator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int insertSelective(OrderGenerator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    List<OrderGenerator> selectByExample(OrderGeneratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    OrderGenerator selectByPrimaryKey(Long orderGeneratorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrderGenerator record, @Param("example") OrderGeneratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrderGenerator record, @Param("example") OrderGeneratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderGenerator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_generator
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderGenerator record);
}
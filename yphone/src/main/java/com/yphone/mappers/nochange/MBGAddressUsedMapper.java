package com.yphone.mappers.nochange;

import com.yphone.model.nochange.AddressUsed;
import com.yphone.model.nochange.AddressUsedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MBGAddressUsedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int countByExample(AddressUsedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int deleteByExample(AddressUsedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long addressUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int insert(AddressUsed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int insertSelective(AddressUsed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    List<AddressUsed> selectByExample(AddressUsedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    AddressUsed selectByPrimaryKey(Long addressUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AddressUsed record, @Param("example") AddressUsedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AddressUsed record, @Param("example") AddressUsedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AddressUsed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_used
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AddressUsed record);
}
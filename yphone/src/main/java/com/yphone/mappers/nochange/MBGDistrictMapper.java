package com.yphone.mappers.nochange;

import com.yphone.model.nochange.District;
import com.yphone.model.nochange.DistrictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MBGDistrictMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int countByExample(DistrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int deleteByExample(DistrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Short districtId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int insert(District record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int insertSelective(District record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    List<District> selectByExample(DistrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    District selectByPrimaryKey(Short districtId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(District record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table district
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(District record);
}
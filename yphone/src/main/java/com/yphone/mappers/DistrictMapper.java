package com.yphone.mappers;

import com.yphone.mappers.nochange.MBGDistrictMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface DistrictMapper extends MBGDistrictMapper {
    List<String> selectProvinces();
    List<String> selectCitiesByProvince(String province);
    List<String> selectCountiesByCity(String city);
    List<Map<Integer,String>> getAddressByID(int id);



}
package com.yphone.mappers;

import com.yphone.mappers.nochange.MBGAddressUsedMapper;
import com.yphone.model.nochange.AddressUsed;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressUsedMapper extends MBGAddressUsedMapper {
    List<AddressUsed> selectByUserID(long userID);
}
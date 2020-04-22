package com.hechuan.mapstrutdemo.mappers;

import com.hechuan.mapstrutdemo.vo.in.UserIVO;
import com.hechuan.mapstrutdemo.vo.out.UserOVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 用户转换mapper
 */
//componentModel值设置为"spring"，表示该接口（UserMapper）实现类会被注册到spring容器中，也就可以在其它类中注入该类使用
//mapstruct编译后会自动生成UserMapper接口的实现类UserMapperImpl，并实现所有接口方法。
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * 将UserIDTO对象转换成UserODTO
     * @param userIDTO
     * @return
     */
    @Mappings({
            @Mapping(target = "userName", expression = "java( this.addRemark(userIDTO.getName()) )"),
            @Mapping(target = "userAge", source = "userIDTO.age"),
            @Mapping(target = "userBirthday", source = "userIDTO.birthday", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "userGender", expression = "java( Integer.valueOf(userIDTO.getGender()) )")
    })
    UserOVO toODTO(UserIVO userIDTO);

    /**
     * 在name值后面添加“-男”
     * @param name
     * @return
     */
    default String addRemark(String name){
        return name + "-男";
    }
}

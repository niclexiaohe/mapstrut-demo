package com.hechuan.mapstrutdemo.mappers;

import com.hechuan.mapstrutdemo.vo.in.UserIVO;
import com.hechuan.mapstrutdemo.vo.out.UserOVO;
import org.mapstruct.*;

/**
 * 用户转换mapper
 */
//componentModel值设置为"spring"，表示该接口（UserMapper）实现类会被注册到spring容器中，也就可以在其它类中注入该类使用
//mapstruct编译后会自动生成UserMapper接口的实现类UserMapperImpl，并实现所有接口方法。

/**
 * nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL：接口参数中只要存在为null的参数，那么返回的结果值都为null。
 * nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT：不会校验接口参数是否为null。
 *
 * nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS：对于一般的属性映射，都会去检查每一个属性是否为空。源属性值不为空才会进行赋值；为空的属性不赋值。表达式映射不判空，因此可能会出现空指针异常。
 * nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION：对于一般的属性映射，且需要格式转换等的映射，才会进行空值校验。不为空才会进行赋值；为空的属性不赋值。。表达式映射不判空，因此可能会出现空指针异常。
 */
@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    /**
     * 将UserIDTO对象转换成UserODTO
     * @param userIDTO
     * @return
     */
    @Mappings({
            @Mapping(target = "userName", expression = "java( this.addRemark(userIDTO.getName()) )"),//表达式
            @Mapping(target = "userAge", source = "userIDTO.age"),//属性映射
            @Mapping(target = "userBirthday", source = "userIDTO.birthday", dateFormat = "yyyy-MM-dd"),//格式转换
            @Mapping(target = "userGender", expression = "java( Integer.valueOf(userIDTO.getGender()) )"),//表达式
            @Mapping(target = "favorite", expression = "java( this.getFavorite() )")//返回常量值。用constant常量有可能被其他表达式更改
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

    /**
     * 获取兴趣爱好--常量
     * @return
     */
    default String getFavorite(){
        return "篮球，游泳";
    }
}

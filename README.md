============================ mapstruct ============================<br>
#【简介】<br>
&emsp;&emsp;MapStruct是一个代码生成器，它基于约定优于配置的方法大大简化了Java Bean类型之间的映射的实现。<br>
生成的映射代码使用简单的方法调用，因此速度快，类型安全且易于理解。MapStruct的表达式功能是为了处<br>
理特殊对象属性的映射问题，比如DTO中的status属性转换成PO中的status需要进一步的处理，这个时候就<br>
需要用到表达式功能了。这里不再赘述关于MapStruct的使用问题，更多的使用教程可参考文档。<br>
MapStruct的中文译文文档：http://www.kailing.pub/MapStruct1.3/index.html#defining-mapper
#【例子】<br>
```Java
@Mapper(componentModel = "spring",imports = {LocalDateTime.class,Date.class, ZoneId.class})//交给spring管理
public interface UserConvert {
    // 用来调用实例 实际开发中可使用注入Spring不写
    //UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    
    //将UserDto的updateTime值赋值为当前时间，将将UserDto的password属性赋值为常量“admin”
    @Mappings({
            @Mapping(target = "updateTime",expression = "java(Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault()).toInstant()))"),
            @Mapping(target = "password",constant = "admin")
    })
    UserDto convert(UserVo userVo);
    
    //将userDto的telPhone属性值映射到UserVo的phone属性
    @Mapping(target = "phone",source = "telPhone")
    UserVo convert(UserDto userDto);
}
```
说明：<br>
（1）用@org.mapstruct.Mapper（不要跟mybatis注解混淆）标记类，说明这是一个实体类型转换接口.<br>
（2）转换Mapper提供了两个转换方法，分别是UserDto--->UserVo和UserVo---->UserDto<br>
（3）componentModel = "spring" 指定 将转换Mapper交给Spring 管理，可实现spring bean 注入.<br>
（4）imports 用于导入Java 表达式所需要的类，expression 接收一个 java() 包括的表达式.<br>
（5）source 代表转换的源，target 代表转换的目标.<br>
（6）MapStruct 最终调用的是 setter 和 getter 方法，而非反射.<br>
（7）对常量赋值不能指定 source 属性，只能这样：@Mapping(target = "password",constant = "admin")。<br>

#【mapStruct重要注解】<br>
（1）@Mapper：注解在接口、类上，这样 MapStruct才会去实现该接口。<br>
&emsp;&emsp;componentModel：该属性用于指定实现类的类型，有几个属性：<br>
&emsp;&emsp;1）default：默认，不使用任何组建类型，可以通过Mappers.getMapper(Class) 方式获取实例对象<br>
&emsp;&emsp;2）spring：在实现类上注解 @Component，可通过 @Autowired 方式注入<br>
&emsp;&emsp;3）jsr330：实现类上添加@javax.inject.Named 和@Singleton注解，可以通过 @Inject注解获取。<br>
（2）@Mappings：配置多个@Mapping单个实体转换时,如字段一致,则不需要配置.<br>
（3）@Mapping：配置属性映射，若源对象属性与目标对象名字一致，会自动映射对应属性。<br>
&emsp;&emsp;1）source：源属性<br>
&emsp;&emsp;2）target：目标属性<br>
&emsp;&emsp;3）dateFormat：可将String到Date日期之间相互转换，通过SimpleDateFormat，该值为SimpleDateFormat的日期格式。<br>
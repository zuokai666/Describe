时间：2019-05-26 09:14:19
位置：Spring.Core [SourceCode master]
描述：
转换服务并没有提供外部可访问的转换器注册器，那就是想屏蔽细节
配置化转化服务直接继承转换服务，转换器注册器，很灵性
转化模块就是可以独立运行，可以复用，没有其他依赖
例子：
基于volatile的双重检查锁
ConversionService conversionService = DefaultConversionService.getSharedInstance();
conversionService.convert("2", Integer.class)

Integer是Number的子类，Number还有很多子类，所以此处的转换器是1->N，是ConverterFactory类型。

Converter 一对一
ConverterFactory 一对N
GenericConverter N对N


描述：时间：2019-05-25 22:08:46
位置：Spring.Core [SourceCode master]
描述：
ConversionService是对外提供转换服务的API
Converter是类型转换器，有一系列的转换器为整个系统工作，就像一个一个的螺丝钉，外部根本不知道内部工作原理
这个时候需要一个调度中心，它知道所有转换器的存在，根据外部的需求使用对应的转换器工作，最后返回给客户需要的值


时间：2019-05-25 11:29:39
位置：hibernate [Util master]
描述：
自写包扫描接口关系，设计了3个顶级接口
ClassExcludeCondition
ClassIncludeCondition
PackageScanner
其中PackageScanner也是ClassIncludeCondition和ClassExcludeCondition的管理器，提供增删改查功能

还提供了一个ClassIncludeCondition的通用实现类AnnotationClassIncludeCondition，基于注解的类包括条件
使用方法，只需要新建的时候传入一个注解即可，类似于Spring的ClassPathBeanDefinitionScanner
ClassPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
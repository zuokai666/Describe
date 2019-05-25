时间：2019-5-25 11:29:39
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

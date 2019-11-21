public class EurekaClientConfig {
	
	//客户端是否从服务器拉取注册信息
	boolean shouldFetchRegistry();
	//客户端从服务器拉取注册信息的时间间隔
    int getRegistryFetchIntervalSeconds();
}
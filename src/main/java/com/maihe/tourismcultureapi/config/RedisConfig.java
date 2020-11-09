package com.maihe.tourismcultureapi.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.parser.ParserConfig;
import com.maihe.tourismcultureapi.utils.FastJson2JsonRedisSerializer;
import com.maihe.tourismcultureapi.utils.RedisTemplate;


/**
 * @Author 姜立
 * 
 * @Description:Redis配置类
 * 
 * @CreateTime:2019/12/20
 *
 */
@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

	@Value("${redis.hostName}")
	private String hostName;

	@Value("${redis.password}")
	private String password;

	@Value("${redis.port}")
	private Integer port;

	@Value("${redis.maxIdle}")
	private Integer maxIdle;

	@Value("${redis.timeout}")
	private Integer timeout;

	@Value("${redis.maxTotal}")
	private Integer maxTotal;

	@Value("${redis.maxWaitMillis}")
	private Integer maxWaitMillis;

	@Value("${redis.minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;

	@Value("${redis.numTestsPerEvictionRun}")
	private Integer numTestsPerEvictionRun;

	@Value("${redis.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;

	@Value("${redis.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${redis.testWhileIdle}")
	private boolean testWhileIdle;
	
	RedisConfig(){
        //打开autotype功能,需要强转的类一次添加其后
        ParserConfig.getGlobalInstance()
                .addAccept("com.maihe.car.model.Admin");
    }

	/**
	 * @Author 姜立
	 * 
	 * @Description:Jedis配置
	 * 
	 * @CreateTime:2019/12/20
	 *
	 */
	@Bean
	public JedisConnectionFactory JedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(hostName);
		redisStandaloneConfiguration.setPort(port);
		// 由于我们使用了动态配置库,所以此处省略
		// redisStandaloneConfiguration.setDatabase(database);
		redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
		JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration
				.builder();
		jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
		JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
				jedisClientConfiguration.build());
		return factory;
	}

	/**
	 * @Author 姜立
	 * 
	 * @Description:实例化 RedisTemplate 对象
	 * 
	 * @CreateTime:2019/12/20
	 *
	 */
	@Bean
	public RedisTemplate functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
		return redisTemplate;
	}

	/**
	 * @Author 姜立
	 * 
	 * @Description:引入自定义序列化
	 * 
	 * @CreateTime:2019/12/20
	 *
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public RedisSerializer fastJson2JsonRedisSerializer() {
		return new FastJson2JsonRedisSerializer<Object>(Object.class);
	}

	/**
	 * @Author 姜立
	 * 
	 * @Description:设置数据存入 redis 的序列化方式,并开启事务
	 * 
	 * @CreateTime:2019/12/20
	 *
	 */
	@SuppressWarnings("unchecked")
	private void initDomainRedisTemplate(RedisTemplate redisTemplate, RedisConnectionFactory factory) {
		// 如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to
		// String！
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
		// 开启事务
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.setConnectionFactory(factory);
	}
}
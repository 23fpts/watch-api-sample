package com.maihe.tourismcultureapi.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author 姜立
 * 
 * @Description:代码自动生成
 * 
 * @CreateTime:2019/12/20
 *
 */
public class Generator {

	// 要生成的表名
	private static String[] tables = { "t_admin" };

	// 数据库配置四要素
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/tourism-culture?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2b8";
	private static String username = "root";
	private static String password = "root";

	public static void main(String[] args) {

		/**
		 * 全局配置
		 */
		GlobalConfig globalConfig = new GlobalConfig();
		globalConfig.setActiveRecord(true); // 开启 ActiveRecord 模式
		globalConfig.setAuthor("jiangli"); // 开发人员
		globalConfig.setOutputDir("E:output"); // 生成文件的输出目录
		globalConfig.setFileOverride(true); // 是否覆盖已有文件

		/**
		 * 数据库配置
		 */
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL); // 数据库类型
		dataSourceConfig.setDriverName(driverName); // 驱动名称
		dataSourceConfig.setUrl(url); // 驱动连接的URL
		dataSourceConfig.setUsername(username); // 数据库连接用户名
		dataSourceConfig.setPassword(password); // 数据库连接密码

		/**
		 * 策略配置项
		 */
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setTablePrefix(new String[] { "t_" }); // 表前缀
		strategyConfig.setNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略
		strategyConfig.setInclude(tables); // 需要包含的表名

		/**
		 * 跟包相关的配置项
		 */
		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setParent("com.maihe.tourismcultureapi"); // 父包名
		packageConfig.setEntity("model"); // Entity包名

		/**
		 * 集成注入配置
		 */
		AutoGenerator gen = new AutoGenerator();
		gen.setGlobalConfig(globalConfig);
		gen.setDataSource(dataSourceConfig);
		gen.setStrategy(strategyConfig);
		gen.setPackageInfo(packageConfig);
		gen.execute();
	}
}
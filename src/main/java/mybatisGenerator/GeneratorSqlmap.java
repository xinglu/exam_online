package mybatisGenerator;


import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

	private void generator() throws Exception{
		List<String> warnings = new ArrayList<>();
//		boolean overwrite = true;
		/*指定 逆向工程配置文件*/
		//File configFile = new File("generatorConfig.xml");
		InputStream in = Resources.getResourceAsStream("mybatisGenerator/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(in);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		in.close();

	} 
	public static void main(String[] args){
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("代码生成-成功!");
	}

}
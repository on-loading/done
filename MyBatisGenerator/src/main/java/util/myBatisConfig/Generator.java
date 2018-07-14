package util.myBatisConfig;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) throws Exception{
        //收集警告信息
        List<String> warnings=new ArrayList<String>();
        //重新生成时是否覆盖原来代码
        boolean overwrite=true;
        //读取配置信息
        InputStream in=Generator.class.getResourceAsStream("/generator/generatorConfig.xml");
        ConfigurationParser configurationParser=new ConfigurationParser(warnings);
        Configuration config=configurationParser.parseConfiguration(in);
        in.close();

        DefaultShellCallback callback=new DefaultShellCallback(overwrite);
        //创建MBG
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        //执行，生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for(String warning:warnings)
            System.out.println(warning);
    }
}

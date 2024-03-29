package com.example.feiyang;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FeiyangApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testMBG() throws Exception {
        System.out.println("test");
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

}

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.spring.boot.MybatisFlexProperties;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author huangyong
 */
public class Main {
  public static void main(String[] args) {
    //配置数据源
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/sardine-system?characterEncoding=utf-8");
    dataSource.setUsername("");
    dataSource.setPassword("");

    //创建配置内容，两种风格都可以。
    GlobalConfig globalConfig = createGlobalConfigUseStyle1();
    //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

    //通过 datasource 和 globalConfig 创建代码生成器
    Generator generator = new Generator(dataSource, globalConfig);

    //生成代码
    generator.generate();
  }

  public static GlobalConfig createGlobalConfigUseStyle1() {
    //创建配置内容
    GlobalConfig globalConfig = new GlobalConfig();

    //设置根包
    globalConfig.setMapperXmlGenerateEnable(true);
    globalConfig.setBasePackage("org.breeze.sardine");

    //设置表前缀和只生成哪些表
    globalConfig.setGenerateTable("user");

    //设置生成 entity 并启用 Lombok
    globalConfig.setEntityGenerateEnable(true);
    globalConfig.setEntityWithLombok(true);
    //设置项目的JDK版本，项目的JDK为14及以上时建议设置该项，小于14则可以不设置
    globalConfig.setEntityJdkVersion(17);

    //设置生成 mapper
    globalConfig.setMapperGenerateEnable(true);

    //可以单独配置某个列
    ColumnConfig columnConfig = new ColumnConfig();
    columnConfig.setColumnName("version");
    columnConfig.setVersion(true);
    ColumnConfig columnConfig1 = new ColumnConfig();
    columnConfig1.setColumnName("deleted");
    columnConfig1.setLogicDelete(true);
    globalConfig.setColumnConfig("user", columnConfig);
    globalConfig.setColumnConfig("user", columnConfig1);

    return globalConfig;
  }
}

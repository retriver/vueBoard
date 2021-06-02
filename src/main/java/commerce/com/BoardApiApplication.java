package commerce.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import commerce.com.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@MapperScan("commerce.com.**.repository") // mybatis mapper     DatabaseConfig 에서설정.
@PropertySource(factory=YamlPropertySourceFactory.class, value="classpath:global.yml",ignoreResourceNotFound = true)
public class BoardApiApplication   extends SpringBootServletInitializer {

	// tomcat 적재후 실행시.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		log.info(" ****  [BoardApiApplication  SpringApplicationBuilder]  **********  "  );
        serverSetting();
        log.info(" ** Roi Application is Running [configure]: "+ System.getProperty("spring.profiles.active"));
        log.info(" ****  [BoardApiApplication  SpringApplicationBuilder]  **********  "  );

		return application.sources(BoardApiApplication.class);
	}



	// spring boot app 실행시 ( local 서버)
	public static void main(String[] args) {
		log.info(" ****  [BoardApiApplication  main]  **********  "  );
		log.info(" ****  [BoardApiApplication  main]  active : "+ System.getProperty("spring.profiles.active")   );
        serverSetting();
		log.info(" ****  [BoardApiApplication  serverSetting  end--------------"  );
		SpringApplication.run(BoardApiApplication.class, args);
        //ApplicationContext ctx = SpringApplication.run(BoardApiApplication.class, args);
		log.info(" ****  [BoardApiApplication  main]  active : "+ System.getProperty("spring.profiles.active")   );
		log.info(" ****  [BoardApiApplication  main]  **********  "  );
	}


	// 서버 설정 initialize
	public static void serverSetting() {
		System.out.println(" **** serverSetting  start ....   "  );
		String ip = "";

		try {
			InetAddress local = InetAddress.getLocalHost();
		    ip = local.getHostAddress();
			System.out.println(" **** serverSetting  ip : "+ip  );
		} catch (UnknownHostException e1) {
		    e1.printStackTrace();
		}

		System.out.println(" **** serverSetting  end  ....   "  );
	}


	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
		return filter;
	}


}

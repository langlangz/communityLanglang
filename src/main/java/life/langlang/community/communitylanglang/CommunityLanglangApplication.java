package life.langlang.community.communitylanglang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("life.langlang.community.communitylanglang,mapper")
public class CommunityLanglangApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityLanglangApplication.class, args);
    }

}

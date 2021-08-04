package life.langlang.community.communitylanglang.provider;

import com.alibaba.fastjson.JSON;
import life.langlang.community.communitylanglang.dto.AccessTokenDTO;
import life.langlang.community.communitylanglang.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;


import java.io.IOException;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-03 20:41
 */
@Component
public class GithubProvider {
    //读取超时为60s
    private static final long READ_TIMEOUT = 60000;
    //写入超时为60s
    private static final long WRITE_TIMEOUT = 60000;
    //连接超时为60s
    private static final long CONNECT_TIMEOUT = 60000;

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body =RequestBody .create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            return null;
        }
    }

}

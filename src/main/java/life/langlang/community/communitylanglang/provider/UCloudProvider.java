package life.langlang.community.communitylanglang.provider;

import cn.ucloud.ufile.UfileClient;
import cn.ucloud.ufile.api.object.ObjectConfig;
import cn.ucloud.ufile.auth.ObjectAuthorization;
import cn.ucloud.ufile.auth.UfileObjectLocalAuthorization;
import cn.ucloud.ufile.bean.PutObjectResultBean;
import cn.ucloud.ufile.exception.UfileClientException;
import cn.ucloud.ufile.exception.UfileServerException;
import life.langlang.community.communitylanglang.exception.CustomizeErrorCode;
import life.langlang.community.communitylanglang.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-18 14:06
 */
@Service
public class UCloudProvider {
    @Value("${ucloud.us3.public-key}")
    private String publicKey;

    @Value("${ucloud.us3.private-key}")
    private String privateKey;
    @Value("${ucloud.us3.bucket-name}")
    private String bucketName;
    @Value("${ucloud.us3.region}")
    private String region;
    @Value("${ucloud.us3.proxySuffix}")
    private String proxySuffix;
    @Value("${ucloud.us3.expires}")
    private Integer  expires;

    public String upload(InputStream fileStream, String mimeType, String fileName){
        String generatedFileName;
        String[] filePaths = fileName.split("\\.");
        if(filePaths.length > 1){
            generatedFileName = UUID.randomUUID().toString() + "." + filePaths[filePaths.length - 1];
        }else{
            return null;
        }

        try {
            ObjectAuthorization objectAuthorization = new UfileObjectLocalAuthorization(publicKey, privateKey);
            ObjectConfig config = new ObjectConfig(region, proxySuffix);
            bucketName = "langlang";
            PutObjectResultBean response = UfileClient.object(objectAuthorization, config)
                    .putObject(fileStream, mimeType)
                    .nameAs(generatedFileName)
                    .toBucket(bucketName)
                    .setOnProgressListener((bytesWritten, contentLength) -> {

                    })
                    .execute();
                    if(response !=null || response.getRetCode() == 0){
                        String url = UfileClient.object(objectAuthorization, config)
                                .getDownloadUrlFromPrivateBucket(generatedFileName, bucketName, expires)
                                .createUrl();
                        return url;
                    }else {
                        throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
                    }
        } catch (UfileClientException e) {
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);

        } catch (UfileServerException e) {
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);

        }
    }

}

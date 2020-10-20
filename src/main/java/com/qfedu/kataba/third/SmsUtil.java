package com.qfedu.kataba.third;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.qfedu.kataba.utils.StrUtil;
import org.json.JSONObject;


/**
 * @program: Kataba
 * @description: Sms 短信 第三方：阿里云-短信服务
 * @author: Feri(邢朋辉)
 * @create: 2020-10-19 15:47
 */
public class SmsUtil {

    //短信发送
    public static boolean sendRCode(String phone,int code){
        //配置对象
        DefaultProfile profile = DefaultProfile.
                getProfile("cn-hangzhou",
                        "<accessKeyId>",
                        "<accessSecret>");
        //实例化短信发送对象
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求对象
        CommonRequest request = new CommonRequest();
        //设置请求方式
        request.setSysMethod(MethodType.POST);
        //设置短信服务的地址
        request.setSysDomain("dysmsapi.aliyuncs.com");
        //系统版本号
        request.setSysVersion("2017-05-25");
        //调用的接口
        request.setSysAction("SendSms");
        //设置域
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //设置签名
        request.putQueryParameter("SignName", "来自邢朋辉的短信");
        //设置模板
        request.putQueryParameter("TemplateCode", "SMS_114390520");
        //设置手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //设置验证码
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            //接收响应
            CommonResponse response = client.getCommonResponse(request);
            String json=response.getData();
            if(StrUtil.checkNotEmpty(json)) {
                JSONObject jo=new JSONObject(json);
                return jo.getString("Code").equals("OK");
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }


}
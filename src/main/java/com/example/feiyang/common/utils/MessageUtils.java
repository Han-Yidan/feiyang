package com.example.feiyang.common.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;

import javax.servlet.http.HttpSession;

/**
 * @author 望舒
 * @date 2022/5/5 16:49
 */

/*
 * 发送短信验证码
 */
public class MessageUtils {
    public SendSmsResponse sendCode(String phoneNumber, String name) {
        SendSmsResponse res = null;

        try {
            /* 必要步骤：
             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对secretId，secretKey。
             */
            Credential cred = new Credential("AKID62i8IDrEMDn7BzWmmX2GDtIQIuGL9gxy",
                    "lFTQ6VdU4NPAernTt2vYutb4GBqDKAj1");

            // 实例化一个http选项，可选，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            // 设置代理（无需要直接忽略）
            // httpProfile.setProxyHost("真实代理ip");
            // httpProfile.setProxyPort(真实代理端口);
            /* 指定接入地域域名，默认就近地域接入域名为 sms.tencentcloudapi.com */
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            /*
             * 非必要步骤:
             * 实例化一个客户端配置对象，可以指定超时时间等配置
             */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK默认用TC3-HMAC-SHA256进行签名, 非必要请不要修改这个字段 */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            /* 实例化要请求产品(以sms为例)的client对象
             * 第二个参数是地域信息，可以直接填写字符串ap-guangzhou，支持的地域列表参考 https://cloud.tencent.com/document/api/382/52071#.E5.9C.B0.E5.9F.9F.E5.88.97.E8.A1.A8 */
            SmsClient client = new SmsClient(cred, "ap-guangzhou",clientProfile);
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
            SendSmsRequest req = new SendSmsRequest();

            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
            String sdkAppId = "1400674597";
            req.setSmsSdkAppId(sdkAppId);

            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名 */
            String signName = "望舒的角落";
            req.setSignName(signName);

            /* 模板 ID: 必须填写已审核通过的模板 ID */
            String templateId = "1392214";
            req.setTemplateId(templateId);

            /* 模板参数: 模板参数的个数需要与 TemplateId 对应模板的变量个数保持一致，若无模板参数，则设置为空 */
            String[] templateParamSet = {name};
            req.setTemplateParamSet(templateParamSet);

            /* 下发手机号码，采用 E.164 标准，+[国家或地区码][手机号]
             * 示例如：+8613711112222， 其中前面有一个+号 ，
             */
            String[] phoneNumberSet = {"+86" + phoneNumber};
            req.setPhoneNumberSet(phoneNumberSet);

            /* 用户的 session 内容（无需要可忽略）: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
            String sessionContext = "";
            req.setSessionContext(sessionContext);

            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
            res = client.SendSms(req);

            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(res));

            return res;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        return res;
    }


    public SendSmsResponse sendMessage(String phoneNumber, String code) {
        SendSmsResponse res = null;
        
        try {
            /* 必要步骤：
             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对secretId，secretKey。
             */
            Credential cred = new Credential("AKID62i8IDrEMDn7BzWmmX2GDtIQIuGL9gxy",
                    "lFTQ6VdU4NPAernTt2vYutb4GBqDKAj1");

            // 实例化一个http选项，可选，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            // 设置代理（无需要直接忽略）
            // httpProfile.setProxyHost("真实代理ip");
            // httpProfile.setProxyPort(真实代理端口);
            /* 指定接入地域域名，默认就近地域接入域名为 sms.tencentcloudapi.com */
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            /*
             * 非必要步骤:
             * 实例化一个客户端配置对象，可以指定超时时间等配置
             */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK默认用TC3-HMAC-SHA256进行签名, 非必要请不要修改这个字段 */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            /* 实例化要请求产品(以sms为例)的client对象
             * 第二个参数是地域信息，可以直接填写字符串ap-guangzhou，支持的地域列表参考 https://cloud.tencent.com/document/api/382/52071#.E5.9C.B0.E5.9F.9F.E5.88.97.E8.A1.A8 */
            SmsClient client = new SmsClient(cred, "ap-guangzhou",clientProfile);
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
            SendSmsRequest req = new SendSmsRequest();

            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
            String sdkAppId = "1400674597";
            req.setSmsSdkAppId(sdkAppId);

            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名 */
            String signName = "望舒的角落";
            req.setSignName(signName);

            /* 模板 ID: 必须填写已审核通过的模板 ID */
            String templateId = "1421890";
            req.setTemplateId(templateId);

            /* 模板参数: 模板参数的个数需要与 TemplateId 对应模板的变量个数保持一致，若无模板参数，则设置为空 */
            String[] templateParamSet = {code};
            req.setTemplateParamSet(templateParamSet);

            /* 下发手机号码，采用 E.164 标准，+[国家或地区码][手机号]
             * 示例如：+8613711112222， 其中前面有一个+号 ，
             */
            String[] phoneNumberSet = {"+86" + phoneNumber};
            req.setPhoneNumberSet(phoneNumberSet);

            /* 用户的 session 内容（无需要可忽略）: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
            String sessionContext = "";
            req.setSessionContext(sessionContext);

            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
            res = client.SendSms(req);

            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(res));

            return res;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        return res;
    }
}

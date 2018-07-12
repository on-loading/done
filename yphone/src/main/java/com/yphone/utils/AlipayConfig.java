package com.yphone.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091800542826";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCc6eqRB2uufW37VuGpiGNlnHGuWdqsB//1BtZbgN6m06jjcnP2MLUR8VIWT92BMJuz8AIz6TS8/77pqKcIzXrq0Xfbhm8VZ5Vtnmw/lQD5m4UmzfYTbd4O0MfCqZZdoFCW4Ufvpdt8JrU6PbuL62Nnnan6bdWIW1ihC5e4GlAKtkl3gktu3FAHYoDUoli3yr5JEQxEuAdiU7LTh/cwHMQbeoWSbgKVx//1QItjt+GhLn1cYQTcaZ6i9lYONbj4b0r2HhzE5KCitDIaaglJW/Jz68vYTOPAf8zdNSyvi2OVXcnXcoLBr+smLwF1bvr5TOECRUanQOMKVf8qdw2yy+p9AgMBAAECggEAJuZaj1+uk1BnDpMoWHYGZi9Vg2qlKlbFXoI2a/LTv7njOZerJdJHYU5ZEkz0Vc2uG/qZITNkLqKcOqLj3evK2CHbu+Fk8oJ+afGHVm/jEP48ETWoFoL7NOMPUrPmIgnXUMBCrCeK9QlHjku1jedp+kr806ec8zPqEeqkzzA+vZi0mdrxT0lyJ7igIGEDF3ekki5tQfEdrmd9iK3BS/aae4eZe1USqPKsmI7aJv4osH2eRit0ciOv3UmDkLGp90IHkajBR4oZ7JD6+A0tR01hRzz6muwpbywlb14Mx+/XDSR1dfZONT1v6ERKAuKVJLHtJdU4JCghCXWN8Y8N1JvfBQKBgQDquvG+umdQmPoDd+fCzM32VASyxMnU5y+iGHPogK/7dlcL7ZVYnRar9AYfr6bFLS6FnU8zA5x9PybVxLcZeZfaLh19dmEWynynoZtSsgy9h7fRLpZ2y17dJ7FB5CbJiXcRsQpkHOsTzdZc5DC1yVMF5OJv+jNrN0wLOe5APsiUWwKBgQCrIdsz2VTo+at5XCTHWuVlv4XHrk/9U0YJs1pdSM2B6TDSKpzJ1M8tulzuvS9ih2hH+6yiybA/jHkHxrG2N8tfpI91T2/+JoOG/TmWC7nGudckj8vhdSy2fPjwtBg+pE7szW6X0fsKx6IUqH2oxAZ+zLy7NL7axHxvZFi4+YZUBwKBgBY6SbYj9LCfK920NxAtULuozSEYnXw5wDr7Uc6MkR2g4TFR+DiB96mk3AeYHJTDaIpikSNljiYWGtlXXXdeGlEg2M4Orbb4ycEd/pVgIvC3r2JxpPHu5DbREWoJ7tpa2BmmyDMewewIK+pz+WDdha0jNYYhDUlz3RGbFMKkr13NAoGBAIubWw+5RKOqylB+8yIO7QVMcP6tHWQ0Avb28ckYE07fxYwuZyngCgPr/NRmUbm3bUML9ZH3p2iwWCwX0/IrIiYsQTwaSeqz0KjW+5uEhVGxWenhxRlwVcGpwgvbX8v6jshv7sC79Gie44Km0ZxUDlhy/aRbKzedA0Z8PkToisURAoGBAMWZkNZJreK5OsLxtkMzsRYWimhpiCzi4wgFORMXRXzd063/0htrl4zro1MzoE/SGNKKXLAkWN3ETehVu0Gc2O/HrwAVUEP4etP8haEuXbOS3jqyx94WVIykcI8+a0WjJcxmlphDbtui2P1K5HD6NANs1LDpkQtRhehNbRkzUltu";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmSUK1I8Dw1ckUnjFdGsQKEI1UxXIwgUfT9biWlsFOnTvOKy8lbwyDr5km8fBMUzavtqiogY26aFQfPE8zuYzkHxUdjGF6U27Njk0X6YYtaOlprrzYL2bI+XjtC3k9yakqGIe7kN/uhPyVABg26Y19kqYeL1xkCDRzWXEL0NEZ4fH8Fpk4t1408KlTa3D/MAct3jnxc75fEkiXePMjC+IMOrZfx3Mt/VVM7V/iRcFv6LTnGTuBf7660GV39/T1hLcl7VSiJxL/q74TnCnidlwQStUIIBZ05bs7h0FkOObw+uIUT7ZPeqpWPymDZRZN9MWfa9vimQlie2IyshdNOUZJwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/yphone/success";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/yphone/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


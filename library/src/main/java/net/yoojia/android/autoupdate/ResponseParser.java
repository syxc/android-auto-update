package net.yoojia.android.autoupdate;


/**
 * 将服务端响应解析数据为Version对象
 *
 * @author ilovedeals
 */
public interface ResponseParser {
    /**
     * 将字符数据解析成Version对象
     *
     * @param response 服务端返回的数据
     * @return Version对象
     */
    Version parser(String response);
}
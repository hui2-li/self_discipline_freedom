package com.hui.bobCat.ipTest;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihui
 * @title: IpPingMain
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/2714:33
 */
public class IpPingMain {

    public static void main(String[] args) {
        try {
            //设置IP地址网段
            String ips = "10.162.245.";
            String ip ;
            InetAddress addip;
            List<Map<Object,Object>> result = new ArrayList<>();
            Thread t1 = new Thread();
            //遍历ip地址
            for (int i = 0; i < 255; i++) {
                ip = ips+i;
                addip = InetAddress.getByName(ip);
                String finalIp = ip;
                InetAddress finalAddip = addip;
                //异步处理
                t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //获取登录过的设备
                        if (!finalIp.equals(finalAddip.getHostName())) {
                            //检查设备是否在线，其中1000ms指定的是超时时间
                            //boolean status = false;     // 当返回值是true时，说明host是可用的，false则不可。
                            int status = 0;
                            try {
                                status = Runtime.getRuntime().exec("ping -c " + finalAddip.getHostName()).waitFor();
                                //status = InetAddress.getByName(finalAddip.getHostName()).isReachable(1000);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //System.out.println("IP地址为:" + finalIp + "\t\t设备名称为: " + finalAddip.getHostName() + "\t\t是否可用: " + (status ? "可用" : "不可用"));
                            System.out.println("IP地址为:" + finalIp + "\t\t设备名称为: " + finalAddip.getHostName() + "\t\t是否可用: " + status);
                            Map<Object, Object> resultMap = new HashMap<>();
                            //resultMap.put(finalIp+finalAddip.getHostName(),status);
                            resultMap.put(finalIp + finalAddip.getHostName(), status);
                            result.add(resultMap);
                        }
                    }
                });
                t1.start();
            }
            t1.join();
            System.out.println(result.size());
        }catch (java.io.IOException uhe) {
            System.err.println("Unable to find: " + uhe.getLocalizedMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：正则表达式验证IP地址
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/4
 * Time(创建时间)： 22:23
 * Version(版本): 1.0
 * Description(描述)： IP 地址由 4 字节构成，每字节的值为 0~255，各字节通过一个句点分隔。因此，IP 地址中的每字节有至少一个，至多三个数字。
 */

public class test
{
    public static void main(String[] args)
    {
        String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        if (args.length != 0)
        {
            //------------------------------------------------------
            long startTime = System.nanoTime();   //获取开始时间
            //------------------------------------------------------
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(args[0]);
            boolean result = false;
            for (String s : args)
            {
                m.reset(s);
                result = m.matches();
                if (result)
                {
                    System.out.println("IP地址 " + s + " 正确");
                }
                else
                {
                    System.out.println("IP地址 " + s + " 错误！！！");
                }
            }
            System.out.println();
            //------------------------------------------------------
            long endTime = System.nanoTime(); //获取结束时间
            if ((endTime - startTime) < 1000000)
            {
                double final_runtime;
                final_runtime = (endTime - startTime);
                final_runtime = final_runtime / 1000;
                System.out.println("算法运行时间： " + final_runtime + "微秒");
            }
            else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
            {
                double final_runtime;
                final_runtime = (endTime - startTime) / 1000;
                final_runtime = final_runtime / 1000;
                System.out.println("算法运行时间： " + final_runtime + "毫秒");
            }
            else
            {
                double final_runtime;
                final_runtime = (endTime - startTime) / 10000;
                final_runtime = final_runtime / 100000;
                System.out.println("算法运行时间： " + final_runtime + "秒");
            }
            Runtime r = Runtime.getRuntime();
            float memory;
            memory = r.totalMemory();
            memory = memory / 1024 / 1024;
            System.out.printf("JVM总内存：%.3fMB\n", memory);
            memory = r.freeMemory();
            memory = memory / 1024 / 1024;
            System.out.printf(" 空闲内存：%.3fMB\n", memory);
            memory = r.totalMemory() - r.freeMemory();
            memory = memory / 1024 / 1024;
            System.out.printf("已使用的内存：%.4fMB\n", memory);
            //------------------------------------------------------
        }
        else
        {
            Scanner input = new Scanner(System.in);
            Pattern p = Pattern.compile(regex);
            Matcher m = null;
            boolean result = false;
            System.out.println("提示：输入-1结束循环");
            String ip;
            while (true)
            {
                System.out.println("请输入IP地址：");
                ip = input.next();
                if (ip.equals("-1"))
                {
                    System.out.println("结束循环！");
                    break;
                }
                else
                {
                    m = p.matcher(ip);
                    result = m.matches();
                    if (result)
                    {
                        System.out.println("IP地址输入正确");
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("IP地址输入错误！！！");
                    }
                }
            }
        }
    }
}

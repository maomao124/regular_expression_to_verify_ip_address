import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：正则表达式验证IP地址
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/4
 * Time(创建时间)： 22:39
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test2
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        // 构造匹配IP地址的模式
        p = Pattern.compile("[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}");
        String[] ips = {"192.168.1.1", "192.168.1.1345", "222.168.1.134", "322.168.1.134"};

        for (String s : ips)
        {
            m = p.matcher(s);
            b = m.matches();
            System.out.println("IP " + s + " 正确：" + b);
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
}

package com.hlnedu.smallchangesys.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 韩来凝
 * @Date: 2023/03/26/14:51
 * @Description:
 */
@SuppressWarnings({"all"})
public class SmallChangeSysOOP {
    //属性
    //定义相关变量
    boolean loop = true;
    Scanner sc = new Scanner(System.in);
    String key = "";

    //零钱通明细
    String details = "---------------零钱通明细(OOP)-------------";

    //3. 完成收益入账，完成功能驱动程序员增加的新的变化和代码
    double money = 0;
    double balance = 0;
    Date date = null;//data 是 java.util.Date 类型，表示日期
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化

    //4.消费
    //定义新变量，保存消费的原因
    String note = "";

    //显示菜单并可以选择
    public void mainMenu() {
        System.out.println("显示零钱通菜单...");

        do {
            System.out.println("\n=======零钱通菜单=======");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.println("请选择(1-4): ");
            key = sc.next();

            //switch 分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        } while (loop);
    }

    //完成零钱通菜单
    public void detail() {
        System.out.println(details);
    }

    //完成收益入账
    public void income() {
        System.out.println("收益入账金额:");
        money = sc.nextDouble();
        //money 的值范围应该校验
        //找出不正确金额的条件，然后给出提示，就直接return
        if (money <= 0) {
            System.out.println("收益入账金额 需要 大于 0");
            return;//退出方法不再执行后面的代码
        }
        balance += money;
        //拼接收益入账信息到 details
        date = new Date();//获取当前日期
        details += "\n收益入账\t+" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
    }

    //消费
    public void pay() {
        System.out.println("消费金额:");
        money = sc.nextDouble();
        //money 的值范围应该校验
        //找出金额不正确的情况
        if (money <= 0 || money > balance) {
            System.out.println("你的消费金额 应该在 0-" + balance);
            return;
        }
        System.out.println("消费说明:");
        note = sc.next();
        balance -= money;
        //拼接消费信息到 details
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
    }

    //退出
    public void exit() {
        //退出时给提示 y/n 必须输入正确的y/n,否则就循环
        //1.定义一个 choice,接受用户的输入
        //2.使用 while + break,来处理接收到的输入时 y 或者 n

        String choice = "";
        while (true) {//要求用户必须输入 y/n , 否则一直循环
            System.out.println("你确定要退出吗? y/n");
            choice = sc.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        //当用户退出while 后在判断输入的是 y 还是 n,就可以决定是否退出
        if (choice.equals("y")) {
            loop = false;
        }
    }
}

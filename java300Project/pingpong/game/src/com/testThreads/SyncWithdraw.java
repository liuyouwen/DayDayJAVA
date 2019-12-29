package com.testThreads;

/**
 * @ClassName SyncWithdraw
 * @Description //模拟取钱操作，synchronized同步块
 * @Author liuyw25167
 * @Date 2019-12-29 17:54
 * @Version 1.0
 **/
public class SyncWithdraw {
    public static void main(String[] args) {
        Account account = new Account("钱包",100);
        Withdrawing you = new Withdrawing(account,80,"you");
        Withdrawing her = new Withdrawing(account, 90,"her");
        you.start();
        her.start();
    }
}

/**
 * 账户对象
 */
class Account{
    String name;
    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class Withdrawing extends Thread{
    Account account;//取钱账户
    int drawingMoney; //取钱数
    int packetTotal; //取的总数
    public Withdrawing(Account account,int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        if(account.money < 0){
            return;  //这个判断提高性能
        }
        //同步块 锁account对象，以解决同步问题
        synchronized (account){
            if(account.money - drawingMoney <0){
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "当前账户余额->" + account.money);
            System.out.println(this.getName() + "共取了钱数" + packetTotal);
        }

    }

}

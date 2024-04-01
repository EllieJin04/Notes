package thread.homework;

/*
public class Homework02 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread(t);
        thread1.setName("t1");
        Thread thread2 = new Thread(t);
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}

//编程取款的线程
//1.因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
//2. 每次取出 1000
class T implements  Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {

            //解读
            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里时，就会去争夺 this对象锁
            //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
            //4. 争夺不到this对象锁，就blocked ，准备继续争夺
            //5. this对象锁是非公平锁.

            synchronized (this) {//
                //判断余额是否够
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000 当前余额=" + money);
            }

            //休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
*/

public class Homework02 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread t1 = new Thread(bankAccount);
        Thread t2 = new Thread(bankAccount);
        t1.start();
        t2.start();

    }
}

class BankAccount implements Runnable {
    private int balance;

    public BankAccount() {
        this.balance = 10000;
    }

    public void withdraw() {

        while (true) {
            synchronized (this) {
                if (balance != 0) {
                    balance -= 1000;
                    System.out.println("User " + Thread.currentThread().getName() + " withdraws 1000 dollars.");
                    System.out.println("The current balance is " + balance);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Override
    public void run() {
        withdraw();
    }
}

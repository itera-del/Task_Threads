/**
 * @author 刘芋池
 * @Description
 * @create 2020/11/4 16:40
 */
public class Main {
    public static void main(String[] args) {
        RunnableImpl run=new RunnableImpl();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
}

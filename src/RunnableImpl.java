import java.io.*;

/**
 * @author 刘芋池
 * @Description
 * @create 2020/11/4 16:26
 */
public class RunnableImpl implements Runnable{
    private static int now=0;
    static File file=new File("C:\\Users\\29858\\Documents\\1.txt");
    static RandomAccessFile raf=null;
    final static int len=1;
    RunnableImpl(){
        try {
            raf=new RandomAccessFile(file,"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            FileWriter fos= null;
            try {
                fos = new FileWriter("D:\\.temp\\3.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (raf){
                byte[] b=new byte[len];
                try {
                    raf.seek(now);
                    int temp= raf.read(b);
                    if(temp==-1){
                        return ;
                    }
                    now+=temp;
                    String str=new String(b);
                    System.out.println(Thread.currentThread().getName()+"正在读取"+str);
                    System.out.println(Thread.currentThread().getName()+"正在写入"+str);
                    fos.write(str);
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

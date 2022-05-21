package DataStructure;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author NingWest
 */
@SuppressWarnings({"all"})
public class Algorithm_1 {

    @Test
    public void sparseArr1() throws IOException {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][4] = 3;
        System.out.println("原二维数组----------------------");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    //算出真实的值
                    sum++;
                }
            }
        }
        //System.out.println(sum);
        int[][] spareArr = new int[sum + 1][3];
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;
        //计数器
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                if (arr[i][k] != 0) {
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = k;
                    spareArr[count][2] = arr[i][k];
                }
            }
        }
        System.out.println("稀疏数组---------------------");
        for (int[] ints : spareArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        //将数组写入文件
        System.out.println("将稀疏数组写入文件中");
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\map.data"));
        for (int i = 0; i < spareArr.length; i++) {
            String format = String.format("%d,%d,%d\n", spareArr[i][0], spareArr[i][1], spareArr[i][2]);
            writer.write(format);
            //将流刷新入文件
            writer.flush();
        }
        //关闭流
        writer.close();
    }
    @Test
    public void sparseArr2() throws IOException {
        //为上面的值
        int sum = 4;
        System.out.println("从文件读入稀疏数组信息-------------------");
        //读取文件信息 将信息写入稀疏数组
        int[][] newSpareArr = new int[sum][3];
        BufferedReader reader = new BufferedReader(new FileReader("src\\map.data"));
        int readI = 0;
        while (reader.ready()) {
            String lineStr = reader.readLine();
            String[] split = lineStr.split(",");
            newSpareArr[readI][0] = Integer.parseInt(split[0]);
            newSpareArr[readI][1] = Integer.parseInt(split[1]);
            newSpareArr[readI][2] = Integer.parseInt(split[2]);
            readI++;
        }
        reader.close();
        //打印稀疏数组确认
        for (int[] ints : newSpareArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        System.out.println("稀疏数组 --> 恢复原二维数组");
        int[][] newArr = new int[newSpareArr[0][0]][newSpareArr[0][1]];
        for (int i = 0; i < newSpareArr[0][2]; i++) {
            //用稀疏数组的值给二维数组赋值
            newArr[newSpareArr[i + 1][0]][newSpareArr[i + 1][1]] = newSpareArr[i + 1][2];
        }
        for (int[] ints : newArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

    @Test
    public void test1() {
        String str = "同学你好啊，同学你是谁谁谁吗？";
        String s = str.replaceAll("同学", "宁西");
        System.out.println(s);
    }
}

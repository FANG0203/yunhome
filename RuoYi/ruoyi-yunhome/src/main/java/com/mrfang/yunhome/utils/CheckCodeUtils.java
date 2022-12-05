package com.mrfang.yunhome.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码工具类
 * randoem.nextInt(最大值-最小值+1)+最小值
 * random.nextInt(11)+20
 */
public class CheckCodeUtils {

    private static String str = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static Random random = new Random();
    private static int width = 120;
    private static int height = 40;

    /**
     * 获取验证码
     * @throws IOException
     */
    public static String getCheckCode(OutputStream outputStream) throws IOException {
        //创建一个图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔对象
        Graphics gc = image.getGraphics();
        //设置画笔的颜色
        gc.setColor(Color.white);
        //设置背景色
        gc.fillRect(0,0,width,height);
        //设置字体
        gc.setFont(new Font("微软雅黑", Font.BOLD, 25));

        //生成随机验证码
        String codeStr = "";
        for (int i = 0; i < 4; i++) {
            //随机下标
            int index = random.nextInt(62);
            //随机字符
            char code = str.charAt(index);
            codeStr+=code;
            //随机设置字体颜色
            gc.setColor(getColor());
            //画到画片上
            gc.drawString(code+"", (i+1)*20, random.nextInt(11)+20);
        }

        //随机生成干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            //随机设置字体颜色
            gc.setColor(getColor());
            gc.drawLine(x1, y1, x2, y2);
        }

        //图片输出到硬盘
        ImageIO.write(image, "jpg", outputStream);
        return codeStr;
    }

    /**
     * 随机颜色
     * @return
     */
    private static Color getColor(){
        int red = random.nextInt(256);
        int blue = random.nextInt(256);
        int green = random.nextInt(256);
        return new Color(red, blue, green);
    }

}

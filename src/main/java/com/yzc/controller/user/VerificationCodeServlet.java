package com.yzc.controller.user;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by wangfujie on 2017/4/16.
 */
@WebServlet("/code.do")
public class VerificationCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String ATTRIBUTE_NAME = "verifycode";
    private final int CODE_LENGTH = 4;
    private static final int Height = 30;
    private boolean ROTATE_FLAG = true;
    private boolean FONT_FLAG = false;
    private String font = "";
    private int fontsize = 15;
    private final String RAND_RANGE = "abcdefhgkmnpqrstuvwxyz"
            + "ABCDEFGHGKLMNPQRSTUVWXYZ" + "123456789";
    public static Random rand = new Random();
    private final char[] CHARS = RAND_RANGE.toCharArray();

    //生成4位的验证码
    private String getRandString() {
        StringBuffer vcode = new StringBuffer();
        for (int i = 0; i < CODE_LENGTH; i++)
            vcode.append(CHARS[rand.nextInt(CHARS.length)]);
        return vcode.toString();
    }

    public static float getRandomJiao() {
        float jiao = 0.0f;
        if (rand.nextFloat() <= 0.5) {
            jiao = rand.nextFloat() - 0.3f;
        } else {
            jiao = -rand.nextFloat() + 0.3f;
        }
        return jiao;
    }

    //设置验证码颜色
    private Color getRandColor(int ll, int ul) {
        if (ll > 255)
            ll = 255;
        if (ll < 1)
            ll = 1;
        if (ul > 255)
            ul = 255;
        if (ul < 1)
            ul = 1;
        if (ul == ll)
            ul = ll + 1;
        int r = rand.nextInt(ul - ll) + ll;
        int g = rand.nextInt(ul - ll) + ll;
        int b = rand.nextInt(ul - ll) + ll;
        Color color = new Color(r, g, b);
        return color;
    }

    private BufferedImage getImage(HttpServletRequest request) {
        //  根据设置的高度计算事宜的fontsize
        int FontSize = Height * 75 / 96;
        // 根据设置的字体及字的个数计算出适宜的宽度
        int width = CODE_LENGTH * FontSize * 4 / 5 + 10;
        // 根据字体大小设置X轴的位移量
        int X_ = FontSize / 2;
        BufferedImage image = new BufferedImage(width, Height,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(getRandColor(100, 255));
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, Height);
        g2.translate(0, Height * 2 / 3);
        double oldrot = 0;

        String vcode = this.getRandString();
        // 把验证码存入session
        request.getSession(true).setAttribute("codes", vcode);
        for (int i = 0; i < CODE_LENGTH; i++) {
            g2.setFont(new Font("Times New Roman", Font.HANGING_BASELINE,
                    FontSize));
            double rot = getRandomJiao();
            if (ROTATE_FLAG) {
                g2.rotate(-oldrot);
                g2.translate(X_ + rand.nextInt(8), 0);
                oldrot = rot;
                g2.rotate(rot);
            }
            String temp = vcode.substring(i, i + 1);
            g2.setColor(getRandColor(1, 100));
            g2.drawString(temp, 0, 0);
        }
        g2.dispose();
        return image;
    }

    public void printImage(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("photos");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 2000);
        String verifyCode = this.getRandString();
        BufferedImage bi = this.getImage(request);
        try {
            ServletOutputStream outStream = response.getOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outStream);
            encoder.encode(bi);
            outStream.flush();
            outStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String code = (String)session.getAttribute("codes");
        String input = req.getParameter("verify");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (input != null && input.equalsIgnoreCase(code)) {
            out.print("ok");
            out.close();
            return;
        }
        out.print("error");
        out.close();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        printImage(request, response);
    }

}

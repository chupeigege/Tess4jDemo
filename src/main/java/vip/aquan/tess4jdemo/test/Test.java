package vip.aquan.tess4jdemo.test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * 缺点：词库未通过训练，识别率不高
 */
public class Test {
    public static void main(String[] args) throws TesseractException {
        System.out.println("OCR 结果:" + new Test().doOCR());
    }

    public String doOCR() throws TesseractException {
        long startTime = System.currentTimeMillis();
        ITesseract instance = new Tesseract();
        //如果未将tessdata放在根目录下需要指定绝对路径
        instance.setDatapath("tessdata");

        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
        instance.setLanguage("chi_sim"); //简体中文
//        instance.setLanguage("eng"); //英文

        // 指定识别图片
        String path = this.getClass().getResource("/ocr.png").getPath();
        File imgDir = new File(path);
        String ocrResult = instance.doOCR(imgDir);
        // 输出识别结果
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        return ocrResult;
    }
}

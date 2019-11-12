package com.dian.oauthserver.util.demo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PdfReplacer {

    private static final Logger logger = LoggerFactory.getLogger(PdfReplacer.class);

    private int fontSize;
    private Map<String, ReplaceRegion> replaceRegionMap = new HashMap<String, ReplaceRegion>();
    private Map<String, Object> replaceTextMap =new HashMap<String, Object>();
    private ByteArrayOutputStream output;
    private PdfReader reader;
    private PdfStamper stamper;
    private PdfContentByte canvas;
    private Font font;

    public PdfReplacer(byte[] pdfBytes) throws DocumentException, IOException{
        init(pdfBytes);
    }

    public PdfReplacer(String fileName) throws IOException, DocumentException{
        FileInputStream in = null;
        try{
            in =new FileInputStream(fileName);
            byte[] pdfBytes = new byte[in.available()];
            in.read(pdfBytes);
            init(pdfBytes);
        }finally{
            in.close();
        }
    }

    private void init(byte[] pdfBytes) throws DocumentException, IOException{
        logger.info("初始化开始");
        reader = new PdfReader(pdfBytes);
        output = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, output);
        canvas = stamper.getOverContent(1);
        setFont(10);
        logger.info("初始化成功");
    }

    private void close() throws DocumentException, IOException{
        if(reader != null){
            reader.close();
        }
        if(output != null){
            output.close();
        }

        output=null;
        replaceRegionMap=null;
        replaceTextMap=null;
    }

    public void replaceText(float x, float y, float w,float h, String text){
        ReplaceRegion region = new ReplaceRegion(text); 	//用文本作为别名
        region.setH(h);
        region.setW(w);
        region.setX(x);
        region.setY(y);
        addReplaceRegion(region);
        this.replaceText(text, text);
    }

    public void replaceText(String name, String text){
        this.replaceTextMap.put(name, text);
    }

    /**
     * 替换文本
     * @throws IOException
     * @throws DocumentException
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     */
    private void process() throws DocumentException, IOException{
        try{
            parseReplaceText();
            canvas.saveState();
            Set<Map.Entry<String, ReplaceRegion>> entrys = replaceRegionMap.entrySet();
            for (Map.Entry<String, ReplaceRegion> entry : entrys) {
                ReplaceRegion value = entry.getValue();
                canvas.setColorFill(BaseColor.RED);
                canvas.rectangle(value.getX(),value.getY(),value.getW(),value.getH());
            }
            canvas.fill();
            canvas.restoreState();
            //开始写入文本
            canvas.beginText();
            for (Map.Entry<String, ReplaceRegion> entry : entrys) {
                ReplaceRegion value = entry.getValue();
                //设置字体
                canvas.setFontAndSize(font.getBaseFont(), getFontSize());
                canvas.setTextMatrix(value.getX(),value.getY()+2/*修正背景与文本的相对位置*/);
                canvas.showText((String) replaceTextMap.get(value.getAliasName()));
            }
            canvas.endText();
        }finally{
            if(stamper != null){
                stamper.close();
            }
        }
    }

    /**
     * 未指定具体的替换位置时，系统自动查找位置
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     */
    private void parseReplaceText() {
        PdfPositionParse parse = new PdfPositionParse(reader);
        Set<Map.Entry<String, Object>> entrys = this.replaceTextMap.entrySet();
        for (Map.Entry<String, Object> entry : entrys) {
            if(this.replaceRegionMap.get(entry.getKey()) == null){
                parse.addFindText(entry.getKey());
            }
        }

        try {
            Map<String, ReplaceRegion> parseResult = parse.parse();
            Set<Map.Entry<String, ReplaceRegion>> parseEntrys = parseResult.entrySet();
            for (Map.Entry<String, ReplaceRegion> entry : parseEntrys) {
                if(entry.getValue() != null){
                    this.replaceRegionMap.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }

    /**
     * 生成新的PDF文件
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     * @param fileName
     * @throws DocumentException
     * @throws IOException
     */
    public void toPdf(String fileName) throws DocumentException, IOException{
        FileOutputStream fileOutputStream = null;
        try{
            process();
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(output.toByteArray());
            fileOutputStream.flush();
        }catch(IOException e){
            logger.error(e.getMessage(), e);
            throw e;
        }finally{
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
            close();
        }
        logger.info("文件生成成功");
    }

    /**
     * 将生成的PDF文件转换成二进制数组
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public byte[] toBytes() throws DocumentException, IOException{
        try{
            process();
            logger.info("二进制数据生成成功");
            return output.toByteArray();
        }finally{
            close();
        }
    }

    /**
     * 添加替换区域
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     * @param replaceRegion
     */
    public void addReplaceRegion(ReplaceRegion replaceRegion){
        this.replaceRegionMap.put(replaceRegion.getAliasName(), replaceRegion);
    }

    /**
     * 通过别名得到替换区域
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     * @param aliasName
     * @return
     */
    public ReplaceRegion getReplaceRegion(String aliasName){
        return this.replaceRegionMap.get(aliasName);
    }

    public int getFontSize() {
        return fontSize;
    }

    /**
     * 设置字体大小
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     * @param fontSize
     * @throws DocumentException
     * @throws IOException
     */
    public void setFont(int fontSize) throws DocumentException, IOException {
        if(fontSize != this.fontSize){
            this.fontSize = fontSize;
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            font = new Font(bf,this.fontSize,Font.BOLD);
        }
    }

    public void setFont(Font font){
        if(font == null){
            throw new NullPointerException("font is null");
        }
        this.font = font;
    }

    private static String file = "D:\\DOWNLOAD\\浏览器下载\\2018年10月体检.pdf";

    public static void main(String[] args) throws IOException, DocumentException {

        PdfReplacer textReplacer = new PdfReplacer(file);
        textReplacer.replaceText("31", "32");
        textReplacer.replaceText("体检", "测试");
        textReplacer.replaceText("2018-10-26 7:55:48", "2019-03-26 7:55:48");
        textReplacer.toPdf("D:\\DOWNLOAD\\浏览器下载\\ticket_out.pdf");


    }


}

package ImageTool.java;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageTool {

    public ImageTool(){
        initLoadImageIcon();
    }

    public void initLoadImageIcon(){

    }

    /**
     * 從遠端網路讀取圖檔
     * @param url
     * @return
     */
    public ImageIcon loadImg(URL url){
        ImageIcon icon = new ImageIcon(url);//整張大圖
        return icon;
    }

    /**
     * 讀取圖檔(使用指定的類別位置當root路徑)
     * @param pathFilename    讀檔路徑+檔名
     * @param sourceClass    指定位置物件類別
     * @return
     */
    public ImageIcon loadImg(String pathFilename, Object sourceClass){
        ImageIcon icon = new ImageIcon(sourceClass.getClass().getResource(pathFilename));//整張大圖
        return icon;
    }

    /**
     * load圖檔(用相對路徑)
     * @param pathFilename    讀檔路徑+檔名
     * @return
     */
    public ImageIcon loadImg(String pathFilename){
        ImageIcon icon = new ImageIcon(pathFilename);//整張大圖
        return icon;
    }


    /**
     * 重置圖檔大小(使用預設縮放演算法)
     * 
     * @param icon    被縮放的圖
     * @param w        寬
     * @param h        高
     * @return
     */
    public ImageIcon resizeImg(ImageIcon icon,int w, int h){
        return resizeImg(icon, w, h, Image.SCALE_DEFAULT);
    }

    /**
     * 重置圖檔大小
     * @param icon    被縮放的圖
     * @param w        寬
     * @param h        高
     * @param s        指定縮放演算法
     * @return
     */
    public ImageIcon resizeImg(ImageIcon icon,int w, int h, int s){
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, s));
    }
    
    /**
     * 以w或h的百分比進行縮放(使用預設縮放演算法)
     * @param icon
     * @param w_scale 0.0~n,小於1為縮放寬度比例，大於1為放大
     * @param h_scale 0.0~n,小於1為縮放高度比例，大於1為放大
     * @return
     */
    public ImageIcon resizeImg_scale(ImageIcon icon, double w_scale, double h_scale){
        return resizeImg_scale(icon, w_scale, h_scale, Image.SCALE_DEFAULT);
    }
    
    /**
     * 以w或h的百分比進行縮放
     * @param icon
     * @param w_scale 0.0~n,小於1為縮放寬度比例，大於1為放大
     * @param h_scale 0.0~n,小於1為縮放高度比例，大於1為放大
     * @param s        指定縮放演算法
     * @return
     */
    public ImageIcon resizeImg_scale(ImageIcon icon, double w_scale, double h_scale, int s){
        if(w_scale >= 0.0 && h_scale >= 0.0){
            int resizeW = (int)(icon.getIconWidth() * w_scale);
            int resizeH = (int)(icon.getIconHeight() * h_scale);
            return resizeImg(icon, resizeW, resizeH, s);
        }
        return icon;
    }

    /**
     * 取得切成 橫row 列，直col行的圖片,切圖順序由左至右，左上至下
     * @param icon    被切的圖
     * @param row    橫的個數
     * @param col    直的個數
     * @return
     */
    public ImageIcon [][] getPieceImg(ImageIcon icon,int row,int col){
        int w = icon.getIconWidth()/row;
        int h = icon.getIconHeight()/col;
        ImageIcon [][] p = new ImageIcon[row][col];

        //切圖
        for(int i = 0; i < row; i++){
            ImageProducer imageproducer = icon.getImage().getSource();
            for(int j = 0; j < col; j++){
                p[i][j] = getPieceImg_we(imageproducer, j * w, i * h, w, h);
            }
        }
        return p;
    }

    /**
     * 取得切成 寬w，高h的圖片，切圖順序由左至右，左上至下
     * @param icon    被切的圖
     * @param w        切出來的小圖塊寬
     * @param h        切出來的小圖塊高
     * @return
     */
    public ImageIcon [][] getPieceImg_wh(ImageIcon icon,int w,int h){    
        int w_cnt = icon.getIconWidth()/w;    //寬要切幾張
        int h_cnt = icon.getIconHeight()/h; //高要切幾張
        ImageIcon [][] p = new ImageIcon[w_cnt][h_cnt];

        //切圖
        for(int i = 0; i < w_cnt; i++){
            ImageProducer imageproducer = icon.getImage().getSource();
            for(int j = 0; j < h_cnt; j++){
                p[i][j] = getPieceImg_we(imageproducer, j * w, i * h, w, h);
            }
        }
        return p;
    }

    /**
     * 指定位置切一塊圖
     * @param imageproducer    被切的大圖
     * @param x                x位置
     * @param y                y位置
     * @param w                寬
     * @param h                高
     * @return
     */
    public ImageIcon getPieceImg_we(ImageProducer imageproducer, int x, int y,int w,int h){        
        CropImageFilter cropimagefilter = new CropImageFilter(x, y, w, h);
        return new ImageIcon( Toolkit.getDefaultToolkit().createImage( new FilteredImageSource( imageproducer , cropimagefilter )));
    }

    /**
     * 指定位置切一塊圖
     * @param icon        被切的大圖
     * @param x            x位置
     * @param y            y位置
     * @param w            寬
     * @param h            高
     * @return
     */
    public ImageIcon getPieceImg_we(ImageIcon icon, int x, int y,int w,int h){        
        ImageProducer imageproducer = icon.getImage().getSource();
        CropImageFilter cropimagefilter = new CropImageFilter(x, y, w, h);
        return new ImageIcon( Toolkit.getDefaultToolkit().createImage( new FilteredImageSource( imageproducer , cropimagefilter )));
    }

    /**
     * 將ImageIcon檔案存成圖檔
     * @param icon
     * @param fileName    檔案路徑+檔名
     * @param salveName 副檔名
     */
    public boolean writeImgIcon(ImageIcon icon, String fileName) {
        try {
            BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);  

            Graphics gc = bufferedImage.createGraphics();     
            gc.drawImage(icon.getImage(),0,0,icon.getImageObserver());
            String [] fileNameAry = fileName.split("[.]");
            String salveName = fileNameAry[fileNameAry.length - 1];//取副檔名
            ImageIO.write(bufferedImage, salveName, new File(fileName));
            gc.dispose();
            gc=null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static void main(String [] args){

        //從遠端讀取圖檔並存檔
        demo1();

        //將圖檔縮放
        demo2();

        //從大圖裡面切一小塊圖存檔
        demo3();
        
        //將大圖切成4x4塊小圖(例如拼圖)，此方式比較耗記憶體資源，若要切大檔圖，請使用切一塊就寫一次檔的方式
        demo4();
        
        //以寬或高的百分比進行縮放
        demo5();
    }

    //--------------------以下為demo範例--------------------------------------

    //從遠端讀取圖檔並存檔
    private static void demo1(){
        try {
            URL url = new URL("http://s.blog.xuite.net/_image/logo.png");
            ImageTool loadIcon = new ImageTool();
            ImageIcon icon = loadIcon.loadImg(url);
            loadIcon.writeImgIcon(icon, ".0.png");
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }

    //將圖檔縮放
    private static void demo2(){
        ImageTool loadIcon = new ImageTool();
        ImageIcon icon = loadIcon.loadImg("0.png");
        ImageIcon resizeIcon = loadIcon.resizeImg(icon, 800, 600);
        loadIcon.writeImgIcon(resizeIcon, "0.png");
    }

    //從大圖裡面切一小塊圖存檔
    private static void demo3(){
        int x = 10;
        int y = 10;
        int w = 50;
        int h = 50;
        ImageTool loadIcon = new ImageTool();
        ImageIcon icon = loadIcon.loadImg("0.png");
        ImageIcon resizeIcon = loadIcon.getPieceImg_we(icon, x, y, w, h);
        loadIcon.writeImgIcon(resizeIcon, "0.png");
    }

    //將大圖切成4x4塊小圖(例如拼圖)，此方式比較耗記憶體資源，若要切大檔圖，請使用切一塊就寫一次檔的方式
    private static void demo4(){
        int row = 4;
        int col = 4;
        ImageTool loadIcon = new ImageTool();
        ImageIcon icon = loadIcon.loadImg("0.png");
        ImageIcon [][] pieceIconAry  = loadIcon.getPieceImg(icon, row, col);

        for(int i = 0; i < pieceIconAry.length; i++){
            for(int j = 0; j < pieceIconAry[i].length; j++){
                loadIcon.writeImgIcon(pieceIconAry[i][j], "0"+i+"_"+j+".png");
            }
        }
    }
    
    private static void demo5(){
         ImageTool loadIcon = new ImageTool();
         ImageIcon icon = loadIcon.loadImg("0.png");
         ImageIcon resizeIcon = loadIcon.resizeImg_scale(icon, 0.5, 0.5);
         loadIcon.writeImgIcon(resizeIcon, "0.png");
    }
}

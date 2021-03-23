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
     * �q���ݺ���Ū������
     * @param url
     * @return
     */
    public ImageIcon loadImg(URL url){
        ImageIcon icon = new ImageIcon(url);//��i�j��
        return icon;
    }

    /**
     * Ū������(�ϥΫ��w�����O��m��root���|)
     * @param pathFilename    Ū�ɸ��|+�ɦW
     * @param sourceClass    ���w��m�������O
     * @return
     */
    public ImageIcon loadImg(String pathFilename, Object sourceClass){
        ImageIcon icon = new ImageIcon(sourceClass.getClass().getResource(pathFilename));//��i�j��
        return icon;
    }

    /**
     * load����(�ά۹���|)
     * @param pathFilename    Ū�ɸ��|+�ɦW
     * @return
     */
    public ImageIcon loadImg(String pathFilename){
        ImageIcon icon = new ImageIcon(pathFilename);//��i�j��
        return icon;
    }


    /**
     * ���m���ɤj�p(�ϥιw�]�Y��t��k)
     * 
     * @param icon    �Q�Y�񪺹�
     * @param w        �e
     * @param h        ��
     * @return
     */
    public ImageIcon resizeImg(ImageIcon icon,int w, int h){
        return resizeImg(icon, w, h, Image.SCALE_DEFAULT);
    }

    /**
     * ���m���ɤj�p
     * @param icon    �Q�Y�񪺹�
     * @param w        �e
     * @param h        ��
     * @param s        ���w�Y��t��k
     * @return
     */
    public ImageIcon resizeImg(ImageIcon icon,int w, int h, int s){
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, s));
    }
    
    /**
     * �Hw��h���ʤ���i���Y��(�ϥιw�]�Y��t��k)
     * @param icon
     * @param w_scale 0.0~n,�p��1���Y��e�פ�ҡA�j��1����j
     * @param h_scale 0.0~n,�p��1���Y�񰪫פ�ҡA�j��1����j
     * @return
     */
    public ImageIcon resizeImg_scale(ImageIcon icon, double w_scale, double h_scale){
        return resizeImg_scale(icon, w_scale, h_scale, Image.SCALE_DEFAULT);
    }
    
    /**
     * �Hw��h���ʤ���i���Y��
     * @param icon
     * @param w_scale 0.0~n,�p��1���Y��e�פ�ҡA�j��1����j
     * @param h_scale 0.0~n,�p��1���Y�񰪫פ�ҡA�j��1����j
     * @param s        ���w�Y��t��k
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
     * ���o���� ��row �C�A��col�檺�Ϥ�,���϶��ǥѥ��ܥk�A���W�ܤU
     * @param icon    �Q������
     * @param row    ��Ӽ�
     * @param col    �����Ӽ�
     * @return
     */
    public ImageIcon [][] getPieceImg(ImageIcon icon,int row,int col){
        int w = icon.getIconWidth()/row;
        int h = icon.getIconHeight()/col;
        ImageIcon [][] p = new ImageIcon[row][col];

        //����
        for(int i = 0; i < row; i++){
            ImageProducer imageproducer = icon.getImage().getSource();
            for(int j = 0; j < col; j++){
                p[i][j] = getPieceImg_we(imageproducer, j * w, i * h, w, h);
            }
        }
        return p;
    }

    /**
     * ���o���� �ew�A��h���Ϥ��A���϶��ǥѥ��ܥk�A���W�ܤU
     * @param icon    �Q������
     * @param w        ���X�Ӫ��p�϶��e
     * @param h        ���X�Ӫ��p�϶���
     * @return
     */
    public ImageIcon [][] getPieceImg_wh(ImageIcon icon,int w,int h){    
        int w_cnt = icon.getIconWidth()/w;    //�e�n���X�i
        int h_cnt = icon.getIconHeight()/h; //���n���X�i
        ImageIcon [][] p = new ImageIcon[w_cnt][h_cnt];

        //����
        for(int i = 0; i < w_cnt; i++){
            ImageProducer imageproducer = icon.getImage().getSource();
            for(int j = 0; j < h_cnt; j++){
                p[i][j] = getPieceImg_we(imageproducer, j * w, i * h, w, h);
            }
        }
        return p;
    }

    /**
     * ���w��m���@����
     * @param imageproducer    �Q�����j��
     * @param x                x��m
     * @param y                y��m
     * @param w                �e
     * @param h                ��
     * @return
     */
    public ImageIcon getPieceImg_we(ImageProducer imageproducer, int x, int y,int w,int h){        
        CropImageFilter cropimagefilter = new CropImageFilter(x, y, w, h);
        return new ImageIcon( Toolkit.getDefaultToolkit().createImage( new FilteredImageSource( imageproducer , cropimagefilter )));
    }

    /**
     * ���w��m���@����
     * @param icon        �Q�����j��
     * @param x            x��m
     * @param y            y��m
     * @param w            �e
     * @param h            ��
     * @return
     */
    public ImageIcon getPieceImg_we(ImageIcon icon, int x, int y,int w,int h){        
        ImageProducer imageproducer = icon.getImage().getSource();
        CropImageFilter cropimagefilter = new CropImageFilter(x, y, w, h);
        return new ImageIcon( Toolkit.getDefaultToolkit().createImage( new FilteredImageSource( imageproducer , cropimagefilter )));
    }

    /**
     * �NImageIcon�ɮצs������
     * @param icon
     * @param fileName    �ɮ׸��|+�ɦW
     * @param salveName ���ɦW
     */
    public boolean writeImgIcon(ImageIcon icon, String fileName) {
        try {
            BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);  

            Graphics gc = bufferedImage.createGraphics();     
            gc.drawImage(icon.getImage(),0,0,icon.getImageObserver());
            String [] fileNameAry = fileName.split("[.]");
            String salveName = fileNameAry[fileNameAry.length - 1];//�����ɦW
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

        //�q����Ū�����ɨæs��
        demo1();

        //�N�����Y��
        demo2();

        //�q�j�ϸ̭����@�p���Ϧs��
        demo3();
        
        //�N�j�Ϥ���4x4���p��(�Ҧp����)�A���覡����ӰO����귽�A�Y�n���j�ɹϡA�ШϥΤ��@���N�g�@���ɪ��覡
        demo4();
        
        //�H�e�ΰ����ʤ���i���Y��
        demo5();
    }

    //--------------------�H�U��demo�d��--------------------------------------

    //�q����Ū�����ɨæs��
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

    //�N�����Y��
    private static void demo2(){
        ImageTool loadIcon = new ImageTool();
        ImageIcon icon = loadIcon.loadImg("0.png");
        ImageIcon resizeIcon = loadIcon.resizeImg(icon, 800, 600);
        loadIcon.writeImgIcon(resizeIcon, "0.png");
    }

    //�q�j�ϸ̭����@�p���Ϧs��
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

    //�N�j�Ϥ���4x4���p��(�Ҧp����)�A���覡����ӰO����귽�A�Y�n���j�ɹϡA�ШϥΤ��@���N�g�@���ɪ��覡
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Yogha Pradana
 */
public class MainWindow extends javax.swing.JFrame {

    JFileChooser fc;
    Mat img_awal,img_hsv, h, s, v, mask,blur,canny,hirarki;
    ArrayList<Mat> hsv, hsv_thres;
    List<MatOfPoint> kontur;
    boolean opened = false;
    double scale;
    //Extend x;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        img_awal = new Mat();
        h = new Mat();
        s = new Mat();
        v = new Mat();
        mask = new Mat();
        blur=new Mat();
        canny=new Mat();
        hirarki=new Mat();
        hsv_thres = new ArrayList<Mat>();
        hsv = new ArrayList<Mat>();
        kontur=new ArrayList<>();
        fc = new JFileChooser(System.getProperty("user.dir"));
        //x =new Extend();
       // x.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_open = new javax.swing.JButton();
        lbl_img_src = new javax.swing.JLabel();
        lbl_img_h = new javax.swing.JLabel();
        lbl_img_s = new javax.swing.JLabel();
        lbl_img_v = new javax.swing.JLabel();
        slider_h = new javax.swing.JSlider();
        slider_s = new javax.swing.JSlider();
        slider_v = new javax.swing.JSlider();
        lbl_img_h_thres = new javax.swing.JLabel();
        lbl_img_s_thres = new javax.swing.JLabel();
        lbl_img_v_thres = new javax.swing.JLabel();
        lbl_h_val = new javax.swing.JLabel();
        lbl_s_val = new javax.swing.JLabel();
        lbl_v_val = new javax.swing.JLabel();
        btn_thres = new javax.swing.JButton();
        lbl_img_mask = new javax.swing.JLabel();
        btn_extend = new javax.swing.JButton();
        lbl_img_other = new javax.swing.JLabel();
        slider_h1 = new javax.swing.JSlider();
        lbl_h1_val = new javax.swing.JLabel();
        slider_s1 = new javax.swing.JSlider();
        lbl_s1_val = new javax.swing.JLabel();
        slider_v1 = new javax.swing.JSlider();
        lbl_v1_val = new javax.swing.JLabel();
        fieldArea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("program");

        btn_open.setText("OPEN TOK");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        lbl_img_src.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_src.setToolTipText("");
        lbl_img_src.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_src.setBorder(javax.swing.BorderFactory.createTitledBorder("Source"));

        lbl_img_h.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_h.setToolTipText("");
        lbl_img_h.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_h.setBorder(javax.swing.BorderFactory.createTitledBorder("Channel H"));

        lbl_img_s.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_s.setToolTipText("");
        lbl_img_s.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_s.setBorder(javax.swing.BorderFactory.createTitledBorder("Channel S"));

        lbl_img_v.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_v.setToolTipText("");
        lbl_img_v.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_v.setBorder(javax.swing.BorderFactory.createTitledBorder("Channel V"));

        slider_h.setMaximum(180);
        slider_h.setValue(0);
        slider_h.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider_hMouseDragged(evt);
            }
        });
        slider_h.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider_hMouseReleased(evt);
            }
        });

        slider_s.setMaximum(255);
        slider_s.setValue(0);
        slider_s.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider_sMouseDragged(evt);
            }
        });
        slider_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider_sMouseReleased(evt);
            }
        });

        slider_v.setMaximum(255);
        slider_v.setValue(0);
        slider_v.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider_vMouseDragged(evt);
            }
        });
        slider_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider_vMouseReleased(evt);
            }
        });

        lbl_img_h_thres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_h_thres.setToolTipText("");
        lbl_img_h_thres.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_h_thres.setBorder(javax.swing.BorderFactory.createTitledBorder("Thres H"));

        lbl_img_s_thres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_s_thres.setToolTipText("");
        lbl_img_s_thres.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_s_thres.setBorder(javax.swing.BorderFactory.createTitledBorder("Thres S"));

        lbl_img_v_thres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_v_thres.setToolTipText("");
        lbl_img_v_thres.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_v_thres.setBorder(javax.swing.BorderFactory.createTitledBorder("Thres V"));

        lbl_h_val.setText("0");

        lbl_s_val.setText("0");

        lbl_v_val.setText("0");

        btn_thres.setText("Threshold");
        btn_thres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thresActionPerformed(evt);
            }
        });

        lbl_img_mask.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_mask.setToolTipText("");
        lbl_img_mask.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_mask.setBorder(javax.swing.BorderFactory.createTitledBorder("Mask"));

        btn_extend.setText("Extend");
        btn_extend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extendActionPerformed(evt);
            }
        });

        lbl_img_other.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_img_other.setToolTipText("");
        lbl_img_other.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_img_other.setBorder(javax.swing.BorderFactory.createTitledBorder("Other"));

        slider_h1.setMaximum(180);
        slider_h1.setValue(180);
        slider_h1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider_h1MouseDragged(evt);
            }
        });
        slider_h1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider_h1MouseReleased(evt);
            }
        });

        lbl_h1_val.setText("0");

        slider_s1.setMaximum(255);
        slider_s1.setValue(255);
        slider_s1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider_s1MouseDragged(evt);
            }
        });
        slider_s1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider_s1MouseReleased(evt);
            }
        });

        lbl_s1_val.setText("0");

        slider_v1.setMaximum(255);
        slider_v1.setValue(255);
        slider_v1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slider_v1MouseDragged(evt);
            }
        });
        slider_v1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slider_v1MouseReleased(evt);
            }
        });

        lbl_v1_val.setText("0");

        fieldArea.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_img_src, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_open)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_extend, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slider_h1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_h1_val, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(slider_s1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_s1_val, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(slider_v1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_img_h_thres, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_img_s_thres, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_img_v_thres, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_img_h, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_img_s, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(slider_h, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_h_val, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(slider_s, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_s_val, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_img_v, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(slider_v, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_v1_val, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_v_val, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_img_mask, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_img_other, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_img_h, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_img_s, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_img_v, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_img_src, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_open))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_h_val)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(slider_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(slider_s, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_s_val, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lbl_v_val)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slider_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbl_h1_val))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slider_s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slider_h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slider_v1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lbl_s1_val))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_v1_val)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_img_h_thres, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_img_s_thres, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_img_v_thres, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_extend)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_img_mask, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_img_other, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(fieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        // TODO add your handling code here:
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            double h_scale, w_scale;
            img_awal = Imgcodecs.imread(fc.getSelectedFile().getPath(),Imgcodecs.IMREAD_COLOR);

            img_hsv = new Mat();
            Imgproc.cvtColor(img_awal, img_hsv, Imgproc.COLOR_BGR2HSV);

            Core.split(img_hsv, hsv);

            System.out.println("HSV channel : " + hsv.size());

            System.out.println("panel height= " + lbl_img_src.getHeight());
            System.out.println("image height= " + img_awal.size().height);

            //scale = 128/ (img_awal.size().height);
            h_scale = (lbl_img_src.getHeight()) / (img_awal.size().height);
            w_scale = (lbl_img_src.getWidth()) / (img_awal.size().width);

            if (h_scale <= w_scale) {
                scale = h_scale;
            } else {
                scale = w_scale;
            }
            System.out.println("scale asli = " + scale);

            if (scale > 1) {
                scale = 1.0;
            }
            System.out.println("scale normalisasi = " + scale);
            drawtoLabelScaled(img_awal, lbl_img_src, scale);

            drawtoLabelScaled(hsv.get(0), lbl_img_h, scale);
            drawtoLabelScaled(hsv.get(1), lbl_img_s, scale);
            drawtoLabelScaled(hsv.get(2), lbl_img_v, scale);

           
            opened = true;
             thres_h();
            thres_s();
            thres_v();

            //drawtoLabel(img_awal, pnl_open);

        }
    }//GEN-LAST:event_btn_openActionPerformed

    private void thres_h(){
        lbl_h_val.setText("" + slider_h.getValue());
        lbl_h1_val.setText("" + slider_h1.getValue());
        if (opened) {
            //Imgproc.threshold(hsv.get(0), h, slider_h.getValue(), slider_h1.getValue(), Imgproc.THRESH_TRUNC);
            Core.inRange(img_hsv, new Scalar(slider_h.getValue(), 0, 0),
                    new Scalar(slider_h1.getValue(), 255 ,255), h);
            drawtoLabelScaled(h, lbl_img_h_thres, scale);
        }
    }
    
    private void thres_s(){
        lbl_s_val.setText("" + slider_s.getValue());
        lbl_s1_val.setText("" + slider_s1.getValue());
        if (opened) {
            //Imgproc.threshold(hsv.get(0), h, slider_h.getValue(), slider_h1.getValue(), Imgproc.THRESH_TRUNC);
            Core.inRange(img_hsv, new Scalar(0, slider_s.getValue(), 0),
                    new Scalar(180, slider_s1.getValue() ,255), s);
            drawtoLabelScaled(s, lbl_img_s_thres, scale);
        }
    }
    
    private void thres_v(){
        lbl_v_val.setText("" + slider_v.getValue());
        lbl_v1_val.setText("" + slider_v1.getValue());
        if (opened) {
            //Imgproc.threshold(hsv.get(0), h, slider_h.getValue(), slider_h1.getValue(), Imgproc.THRESH_TRUNC);
            Core.inRange(img_hsv, new Scalar(0, 0, slider_v.getValue()),
                    new Scalar(180, 255, slider_v1.getValue()), v);
            drawtoLabelScaled(v, lbl_img_v_thres, scale);
        }
    }
    
    private void slider_hMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_hMouseReleased
        // TODO add your handling code here:
        thres_h();
    }//GEN-LAST:event_slider_hMouseReleased

    private void slider_hMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_hMouseDragged
        // TODO add your handling code here:
        thres_h();
    }//GEN-LAST:event_slider_hMouseDragged

    private void slider_sMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_sMouseReleased
        // TODO add your handling code here:
        thres_s();
    }//GEN-LAST:event_slider_sMouseReleased

    private void slider_sMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_sMouseDragged
        // TODO add your handling code here:
        thres_s();
    }//GEN-LAST:event_slider_sMouseDragged

    private void slider_vMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_vMouseDragged
        // TODO add your handling code here:
        thres_v();
    }//GEN-LAST:event_slider_vMouseDragged

    private void slider_vMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_vMouseReleased
        // TODO add your handling code here:
        thres_v();
    }//GEN-LAST:event_slider_vMouseReleased

    private void btn_thresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thresActionPerformed
        // TODO add your handling code here:
Random rng = new Random(12345);
        Mat dw=img_awal.clone();
        Core.bitwise_and(h, s, mask);
        Core.bitwise_and(mask, v, mask);
        drawtoLabelScaled(mask, lbl_img_mask, scale);
        
        //Imgproc.blur(mask, blur, new Size(3,3));
        Imgproc.medianBlur(mask, blur, 7);
        //Imgproc.Canny( mask, canny, 100, 200);
        Imgproc.Laplacian(mask, canny,8 );
        kontur.clear();
        Imgproc.findContours(canny, kontur, hirarki, Imgproc.RETR_CCOMP, Imgproc.CHAIN_APPROX_SIMPLE);
        System.out.println("kontur ditemukan :"+kontur.size());
                Mat drawing = Mat.zeros(canny.size(), CvType.CV_8UC3);
                
                Rect rect = null;
        for (int i = 0; i < kontur.size(); i++) {
            
            Scalar color = new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            //Imgproc.drawContours(dw, kontur, i, color, 2, Core.LINE_8, hirarki, 0, new Point());
            //if(kontur.get(i).height()<(dw.height()/10)&&kontur.get(i).width()<(dw.width()/10))
            
            rect = Imgproc.boundingRect(kontur.get(i));
            //System.out.println("Kontur "+i+" : "+rect.br()+" , "+rect.);
            System.out.println("kontur :"+i+" area :"+rect.area());
            if(rect.area()>Integer.parseInt(fieldArea.getText()))
            Imgproc.rectangle(dw, rect.br(),rect.tl(),  color,2, 8,0); 
            
            
        }
        Imgcodecs.imwrite("out.jpg", dw);
        drawtoLabelScaled(canny, lbl_img_other, scale);
    }//GEN-LAST:event_btn_thresActionPerformed

    private void btn_extendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extendActionPerformed
        // TODO add your handling code here:
        //x.setVisible(true);
        
    }//GEN-LAST:event_btn_extendActionPerformed

    private void slider_h1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_h1MouseDragged
        // TODO add your handling code here:
        thres_h();
    }//GEN-LAST:event_slider_h1MouseDragged

    private void slider_h1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_h1MouseReleased
        // TODO add your handling code here:
        thres_h();
    }//GEN-LAST:event_slider_h1MouseReleased

    private void slider_s1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_s1MouseDragged
        // TODO add your handling code here:
        thres_s();
    }//GEN-LAST:event_slider_s1MouseDragged

    private void slider_s1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_s1MouseReleased
        // TODO add your handling code here:
        thres_s();
    }//GEN-LAST:event_slider_s1MouseReleased

    private void slider_v1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_v1MouseDragged
        // TODO add your handling code here:
        thres_v();
    }//GEN-LAST:event_slider_v1MouseDragged

    private void slider_v1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slider_v1MouseReleased
        // TODO add your handling code here:
        thres_v();
    }//GEN-LAST:event_slider_v1MouseReleased

    public BufferedImage toBufferedImage(Mat m) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (m.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels() * m.cols() * m.rows();
        byte[] b = new byte[bufferSize];
        m.get(0, 0, b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);
        return image;
    }

    private void drawtoPanel(Mat image, javax.swing.JPanel panel) {
        BufferedImage buff = toBufferedImage(image);

        Graphics g1 = panel.getGraphics();

        if (g1.drawImage(buff, 0, 0, buff.getWidth(), buff.getHeight(), 0, 0, buff.getWidth(), buff.getHeight(), null));
    }

    private void drawtoLabelScaled(Mat image, JLabel label, double scale) {
        Mat imshow = image.clone();
        Imgproc.resize(imshow, imshow, new Size(0, 0), scale, scale, Imgproc.INTER_LINEAR);
        drawtoLabel(imshow, label);
    }

    private void drawtoLabel(Mat image, JLabel label) {
        BufferedImage buff = toBufferedImage(image);
        ImageIcon icon = new ImageIcon();

        label.setIcon(new ImageIcon(buff));

    }

    private void drawtoPanelScaled(Mat image, javax.swing.JPanel panel, double h_scale) {
        Mat imshow = image.clone();
        Imgproc.resize(imshow, imshow, new Size(0, 0), h_scale, h_scale, Imgproc.INTER_LINEAR);
        drawtoPanel(imshow, panel);
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_extend;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_thres;
    private javax.swing.JTextField fieldArea;
    private javax.swing.JLabel lbl_h1_val;
    private javax.swing.JLabel lbl_h_val;
    private javax.swing.JLabel lbl_img_h;
    private javax.swing.JLabel lbl_img_h_thres;
    private javax.swing.JLabel lbl_img_mask;
    private javax.swing.JLabel lbl_img_other;
    private javax.swing.JLabel lbl_img_s;
    private javax.swing.JLabel lbl_img_s_thres;
    private javax.swing.JLabel lbl_img_src;
    private javax.swing.JLabel lbl_img_v;
    private javax.swing.JLabel lbl_img_v_thres;
    private javax.swing.JLabel lbl_s1_val;
    private javax.swing.JLabel lbl_s_val;
    private javax.swing.JLabel lbl_v1_val;
    private javax.swing.JLabel lbl_v_val;
    private javax.swing.JSlider slider_h;
    private javax.swing.JSlider slider_h1;
    private javax.swing.JSlider slider_s;
    private javax.swing.JSlider slider_s1;
    private javax.swing.JSlider slider_v;
    private javax.swing.JSlider slider_v1;
    // End of variables declaration//GEN-END:variables
}

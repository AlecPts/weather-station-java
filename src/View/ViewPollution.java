/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import Model.DbManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author apeyt
 */
public class ViewPollution extends JPanel implements Observer {
    
    ChartPanel chartPanel;
    DbManager dataPollution;
    
    public ViewPollution(DbManager dataPollution) {
        this.dataPollution = dataPollution;

        initChart( ); 
        
        validate();
        repaint();
   }

    private void initChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Pollution chart",
                "Date",
                "Air Quality Indice",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        
        chartPanel = new ChartPanel( lineChart );
        
        this.add( chartPanel );
        
    }

    @Override
    public Dimension getPreferredSize() {
        
        Dimension dim = this.size();
        chartPanel.setPreferredSize(new Dimension(800, 600));
        return new Dimension(800, 600);
    }
   
    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

//        ArrayList<int[]> dataPollutionList = dataPollution.recoverAllData();
//        System.out.println(dataPollutionList);

//        for (int[] dataList : dataPollutionList) {
//            int dt = dataList[0];
//            int aqi = dataList[1];
//
//            // Format datetime
//            long epoch = ((long) dt) * 1000;  // to long and millisecond
//            Date date = new Date(epoch);
//
//            String pattern = "yyyy-MM-dd";
//            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//            String dateString = sdf.format(date);
//
//            String year = dateString.substring(0, 4);
//
//            dataset.addValue(dataList[1], "pollution", String.valueOf(dataList[0]));
//        }


        dataPollution.printAllData();

        ArrayList<int[]> dataPollutionList = dataPollution.recoverAllData();

        for (int[] dataList : dataPollutionList) {
            System.out.println(dataList[0] + " " + dataList[1]);
        }

        return dataset; 
    }

    @Override
    public void update(Observable o, Object arg) {
        initChart();
    }
}

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.text.DecimalFormat;
import java.util.*;
import java.text.SimpleDateFormat;

class Donut {    
    public String ID;  //unique id for each type of donut
    public String Name;    //unique name for each type of donut
    public double price;   //price of each donut
    private int store=20;   //default store for each donut is 20


    
    public Donut()
    {
        
    }
    public Donut(Donut a)
    {
        this.ID=a.getID();  //get id of donut
        this.Name=a.getName();  //set name for donut
        this.price=a.getPrice();    //set price of donut
    }
    
    public String getID()
    {
        return ID;  //get id of donut
    }
    
    public double getPrice()
    {
        return price;   //get price of donut
    }
    
    public String getName()
    {
        return Name;    //get name of donut
    }
    
    public int getStore()
    {
        return store;   //get store of donut
    }
    

    
    public void setStore()
    {
        this.store--;   //set store-- when call
    }
    

}

class NormalDonut extends Donut{    //inheritance from donut
    public NormalDonut(String id, String n){
        ID = id;
        Name = n;
        price=4.00; //price of normal donut=4
    }
}

class PremiumDonut extends Donut{
    public PremiumDonut(String id, String n){
        ID = id;
        Name = n;
        price=5.00; //price of premium donu=5
    }
}


class Sales
{
	private final String id;    //unique id gor every sales
	private final Date date ;   //date of sales
	private List<Donut> salesItem=new ArrayList<>();    //contain donut sales in 1 submission 
	private double totalAmount; //the total amount of single sales
        DecimalFormat df= new DecimalFormat("#0.00");   //set decimal format to 2 decimal places
	private static int salesCount = 0;  //calculated number of sales
	private int itemCount;  //calculate number of sales donut i

	public Sales()  //default constructor
	{
		id = String.valueOf(10000+salesCount);  //declare unique id of sales
		date = new Date();  //set date for sales
		salesItem = new ArrayList<>();  //list of sales donur
		itemCount = 0;  //number of item within sales list
                salesCount+=1;
	}

        public String getID()
        {
            return id;  //return sales id
        }
        
	public void addItem(Donut donut)
	{
		salesItem.add(donut);   //add donut selected into list
                donut.setStore();   //get store of donut
                totalAmount+=donut.getPrice();  //get total amount of a sales
		itemCount++;    //item within a sales increase by 1 once 1 donut is add
	} 

	public double getTotalAmount()
	{
		return totalAmount; //return total amount of a sales
	}
        
        public int getItemCount()
        {
            return itemCount;   //return number of donut in a sales
        }
        
        @Override
	public String toString()    //print report(overloaded function)
	{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String d="";
             for (int i = 0; i < itemCount; i++)
                {   
                    Donut temp=salesItem.get(i);
                   // System.out.println(temp.getName());
                    d+=temp.getID()+"\t"+temp.getName()+"\t\t"+df.format(temp.getPrice())+"\n";
                }
            return ("ID: "+ id +"\nDate: "+ dateFormat.format(date)+"\nID\tItem Name\t\t\tPrice(RM)"+"\n"+d+"\nTotal Amount(RM): "+ df.format(totalAmount));   
	}

}


class Report{
    private final List<Sales> SalesList=new ArrayList<>(); //every sales was stored within SalesList
    private double totalOfTotal=0;//total amount of sales
    private Donut HighestSales;//highest quatity donut sales
    DecimalFormat df= new DecimalFormat("#0.00");//set decimal format to 2 decimal places
    private int salesCount=0;//number of sales add into salesList
    
    public Report()//default constructor
    {
        
    }
    public Report(Sales a)//overloaded constructor
    {
        SalesList.add(a);// add sales into sales lists report
        salesCount++;//the number of sales increases once sales is added
        //totalOfTotal+=a.getTotalAmount();
    }
    public void AddSales(Sales a)
    {
        SalesList.add(a);// add sales into sales lists report
        salesCount++;//the number of sales increases once sales is added
    }
    public void AddHighest(Donut a,Donut b,Donut c,Donut d)
    {
        int aCount;//get the donut A count, a and c was same tpe of donut
        int bCount;//get the donut B count, d and b was same tpe of donut
        
        aCount=a.getStore()+c.getStore();   //calculate store of donut a and c
        bCount=d.getStore()+b.getStore();   //calculate store of donut b and d
        
        if(aCount<bCount)
        {
            this.HighestSales=a;//set highest = donutA
        }
        else
        {
            this.HighestSales=b;//set highest = donutB
        }   
    }
    public double getTotalOfTotal()
    {
        return totalOfTotal;    //get total amount of every sales
    }
    public int getSalesCount()
    {
        return salesCount;  // get number of sales
    }
    public void calTOT()    //calculate totalOfTotal
    {
        Sales temp;
        for (int i=0;i<salesCount;i++)
        {
            temp=SalesList.get(i);
            totalOfTotal+= temp.getTotalAmount();
        }
    }
    @Override
    public String toString()    //return report (overloaded function)
    {
        calTOT();    
        String d="";           
        for (int i = 0; i < salesCount; i++)  
        {                  
            Sales temp=SalesList.get(i); 
            d+=temp.getID()+"\t\t"+df.format(temp.getTotalAmount())+"\n";           
        } 
        return ("\nID\t\tPrice(RM)"+"\n"+d+"\nTotal Amount (RM): "+ df.format(totalOfTotal)); 
    }
}


public final class DonutSales 
{

    static NormalDonut donutA=new NormalDonut("0001","Donut Forest Glam(Normal)");    //declare new donut for sales
    static NormalDonut donutB=new NormalDonut("0003","Donut Greentea(Normal)");     //declare new donut for sales
    static PremiumDonut donutC=new PremiumDonut("0002","Donut Forest Glam(Premium)");    //declare new donut for sales
    static PremiumDonut donutD=new PremiumDonut("0004","Donut Greentea(Premium)");    //declare new donut for sales
    private JFrame mf;      //declare new JFrame for main window
    private JFrame orderReport; //declare new JFrame for order report window
    private JFrame reportWindow;    //declare new JFrame for report window
    private JFrame orderWindow;     //declare new JFrame for order window
    private static ArrayList<Sales> salesList;  //declare new ArrayList for sales list
    private static ArrayList<Donut> salesDonut; //declare new ArrayList for sales donut
    private static ArrayList<Integer> QO ;  //declare ArrayList for order quality
    private static ArrayList <JSpinner> JS;     //declare new JSpinner for order
    private int salesIndex=0;   //declare number of sales /number of click submit
    private final Report report=new Report ();  //decalre a new report object(only 1)
     
    public DonutSales()
    {
        window();   //call main window
    }

    public void window()
    {
        mf=new JFrame();    //set characteristic of main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        mf.setTitle("DOnut Ordering System");
        mf.setLayout(new FlowLayout());
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setVisible(true);
        
        ImageIcon icon; //set gif file in main pages
        icon = new ImageIcon("donut.gif");
        JLabel imageLabel = new JLabel(icon,SwingConstants.LEFT);
        
        JLabel mainLabel = new JLabel("Welcome to Donut Order System",SwingConstants.RIGHT);    //set string within main page
        mainLabel.setFont(new Font("Times New Romas",Font.PLAIN,30));
        
        JPanel mainPanel= new JPanel(); //set a main panel to add imageLabel and mainLabel
        mainPanel.add(imageLabel);
        mainPanel.add(mainLabel);
        
        JButton donutOrder = new JButton("Order Donut");    //button for order donut
        JButton donutReport =new JButton("Report");     //button for generate report
        
        donutOrder.addActionListener((ActionEvent event) -> {
            OrderDonut orderDonut = new OrderDonut();
        } //action when order donut button click
        );
        
        donutReport.addActionListener((ActionEvent event) -> {
            ReportDonut reportDonut = new ReportDonut();
        } //action when report button click
        ); 
        JPanel contentPane=new JPanel();    //declare new Panel to add mian panel and button together
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.red);
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));

        contentPane.add(mainPanel, BorderLayout.PAGE_START);
        contentPane.add(donutOrder,BorderLayout.CENTER);
        contentPane.add(donutReport,BorderLayout.PAGE_END);
        mf.add(contentPane);    //mainframe contain all elements
        mf.pack();
    }
    
    private class OrderDonut
    {
        public OrderDonut()
        {
            orderWindow = new JFrame(); //declare characteristics of order window
            orderWindow.setTitle("Donut Order");
            orderWindow.setLayout(new FlowLayout());
            
            JPanel contentPane=new JPanel();    //content panel consist of topPanel
            contentPane.setOpaque(true);
            contentPane.setBackground(Color.red);
            contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            contentPane.setLayout(new BorderLayout(10,10));
            
            JPanel topPanel = new JPanel(); //Panel to stored 2 top panel(1 and 2)
            topPanel.setOpaque(true);
            topPanel.setBackground(Color.WHITE);
            topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            topPanel.setLayout(new BorderLayout(20,20));
            topPanel.setBorder(BorderFactory.createTitledBorder("Donut List"));    
            
            JPanel topPanel1 = new JPanel();//for normal donut table
            topPanel1.setOpaque(true);
            topPanel1.setBackground(Color.WHITE);
            topPanel1.setBorder( BorderFactory.createTitledBorder("Normal Donut List"));    
            topPanel1.setPreferredSize(new Dimension(500,100));
            
            JPanel topPanel2 = new JPanel();//for premium donut table
            topPanel2.setOpaque(true);
            topPanel2.setBackground(Color.WHITE);
            topPanel2.setBorder( BorderFactory.createTitledBorder("Premium Donut List")); 
            topPanel2.setPreferredSize(new Dimension(500,100));
           
            JPanel orderPanela = new JPanel(new FlowLayout(FlowLayout.LEFT));//for normal donut order form 
            orderPanela.setOpaque(true);
            orderPanela.setBackground(Color.WHITE);
            orderPanela.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            orderPanela.setLayout(new BorderLayout(30,30));
            orderPanela.setBorder( BorderFactory.createTitledBorder("Order for Normal Donut"));  
            
            JPanel orderPanelb = new JPanel(new FlowLayout(FlowLayout.LEFT));//for premium donut order form 
            orderPanelb.setOpaque(true);
            orderPanelb.setBackground(Color.WHITE);
            orderPanelb.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            orderPanelb.setLayout(new BorderLayout(30,30));
            orderPanelb.setBorder( BorderFactory.createTitledBorder("Order for Premium Donut"));  
            
            JPanel orderPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));//for donut type A order form 
            orderPanel1.setOpaque(true);
            orderPanel1.setBackground(Color.WHITE);
            orderPanel1.setBorder( BorderFactory.createTitledBorder("Donut Forest Glam")); 
            
            JPanel orderPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));//for donut type B order form 
            orderPanel2.setOpaque(true);
            orderPanel2.setBackground(Color.WHITE);
            orderPanel2.setBorder( BorderFactory.createTitledBorder("Donut Greentea")); 
            
            JPanel orderPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));//for donut type C order form 
            orderPanel3.setOpaque(true);
            orderPanel3.setBackground(Color.WHITE);
            orderPanel3.setBorder( BorderFactory.createTitledBorder("Donut Forest Glam")); 
            
            JPanel orderPanel4 = new JPanel();//for donut type D order form 
            orderPanel4.setOpaque(true);
            orderPanel4.setBackground(Color.WHITE);
            orderPanel4.setBorder( BorderFactory.createTitledBorder("Donut Greentea")); 
            
            SpinnerNumberModel model1 =new SpinnerNumberModel(0,0, donutA.getStore(),1);   //set default,min,max and step of spinner
            SpinnerNumberModel model2 =new SpinnerNumberModel(0,0, donutB.getStore(),1);   
            SpinnerNumberModel model3 =new SpinnerNumberModel(0,0, donutC.getStore(),1);   
            SpinnerNumberModel model4 =new SpinnerNumberModel(0,0, donutD.getStore(),1);   
            JS = new ArrayList<>(); 
            JSpinner j1=new JSpinner(model1);   //declare 4 spinner for each type of donut
            JSpinner j2=new JSpinner(model2);
            JSpinner j3=new JSpinner(model3);
            JSpinner j4=new JSpinner(model4);
            JS.add(j1);     //number of JSpinner correspond to number of type of donut
            JS.add(j2);
            JS.add(j3);
            JS.add(j4);
           
            QO = new ArrayList<>(); //QO for quality order
            Integer qo1=0;      //4 element qo because 4 type of donut
            Integer qo2=0;
            Integer qo3=0;
            Integer qo4=0;
            QO.add(qo1);
            QO.add(qo2);
            QO.add(qo3);
            QO.add(qo4);
            
            salesList=new ArrayList<>(); //declare sales before enter for loop
            Sales a =new Sales();Sales b =new Sales();Sales c =new Sales();Sales d =new Sales();Sales e =new Sales();Sales f =new Sales();Sales g =new Sales();
            Sales h =new Sales();Sales i =new Sales();Sales j =new Sales();Sales k =new Sales();Sales l =new Sales();Sales m =new Sales();Sales n =new Sales();
            salesList.add(a);salesList.add(b);salesList.add(c);salesList.add(d);salesList.add(e);salesList.add(f);salesList.add(g);
            salesList.add(h);salesList.add(i);salesList.add(j);salesList.add(k);salesList.add(l);salesList.add(m);salesList.add(n);
            
            orderPanel1.add(j1);    //4 panel to store 4 spinner
            orderPanel1.setPreferredSize(new Dimension(75,75));
            orderPanel2.add(j2);
            orderPanel2.setPreferredSize(new Dimension(150,150));
            orderPanel3.add(j3);
            orderPanel3.setPreferredSize(new Dimension(50,50));
            orderPanel4.add(j4);
            orderPanel4.setPreferredSize(new Dimension(50,50));

            orderPanela.add(orderPanel1,BorderLayout.PAGE_START);   //group normal and premium type of donut separately
            orderPanela.add(orderPanel2,BorderLayout.BEFORE_LINE_BEGINS);
            orderPanela.setPreferredSize(new Dimension(175,175));
            orderPanelb.add(orderPanel3);
            orderPanelb.add(orderPanel4,BorderLayout.PAGE_END);
            orderPanelb.setPreferredSize(new Dimension(175,175));

            String[]columnNames={"Donut ID","Donut Name,","Quantity","Price (RM)"}; //table column names
            Object[][] data1 = //normal donut list information
            {
                {donutA.getID(),donutA.getName(),donutA.getStore(),donutA.getPrice()},
                {donutB.getID(),donutB.getName(),donutB.getStore(),donutB.getPrice()},
            };
            JTable table1=new JTable(data1,columnNames); 
            JScrollPane jscr1=new JScrollPane(table1);  //to show table column names
            topPanel1.add(jscr1);  
           
            Object[][] data2 =//premium donut list information
            {
                {donutC.getID(),donutC.getName(),donutC.getStore(),donutC.getPrice()},
                {donutD.getID(),donutD.getName(),donutD.getStore(),donutD.getPrice()},
            };
            JTable table2=new JTable(data2,columnNames); 
            JScrollPane jscr2=new JScrollPane(table2);  //to show table column names
            topPanel2.add(jscr2);
                          
            JButton orderSubmit =new JButton("Submit"); //button of submit order
            orderSubmit.setFont(new Font("Times New Romas",Font.PLAIN,15));
            orderSubmit.addActionListener((ActionEvent ae) -> 
            {
                SubmitOrder submitOrder=new SubmitOrder();
            });
  
            topPanel.add(topPanel1,BorderLayout.PAGE_START);    //normal donut list
            topPanel.add(topPanel2,BorderLayout.PAGE_END);  //premium donut list
            contentPane.add(topPanel);  //total donut list
            orderWindow.add(contentPane);
            orderWindow.add(orderPanela);
            orderWindow.add(orderPanelb);
            orderWindow.add(orderSubmit);
            
            orderWindow.setVisible(true);
            orderWindow.pack();
        }
    }
    private class ReportDonut
    {
        public ReportDonut()
        {
            reportWindow = new JFrame();    //characteristic of report window
            reportWindow.setTitle("Final Report");
            reportWindow.setLayout(new FlowLayout());
            
            JLabel finalReport=new JLabel("Fianl Report for total sales");
            finalReport.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            
            JTextArea finalDonutReport=new JTextArea(report.toString());//print report
            report.calTOT();
            
            JPanel content=new JPanel();
 
            content.add(finalReport,BorderLayout.PAGE_START);
            content.add(finalDonutReport,BorderLayout.PAGE_END);
            reportWindow.add(content);
            reportWindow.setVisible(true);
            reportWindow.pack();
        }
    }
    private class SubmitOrder
    {
        public SubmitOrder()
        {
            for (int i=0;i<JS.size();i++)
            {
                QO.set(i,(Integer)(JS.get(i).getValue()));
            }
            if(QO.get(1)==0&&QO.get(2)==0&&QO.get(3)==0&&QO.get(0)==0)  //check value for input
            {
                orderWindow.dispose();  //close window if no input value
            }
            else
            {
                callSales();    //record if value insert
            }
        }

        final void callSales()
        {
            for (int i=0;i<JS.size();i++)//size of spinner
            {
                switch (i) {    //add donut into sales list depend on input number of spinner
                    case 0: //QO.get(i)is the input numberof spinner
                        for (int k=0;k<QO.get(i);k++)
                        {
                            salesList.get(salesIndex).addItem(donutA);
                        }
                        break;
                    case 1:
                        for (int k=0;k<QO.get(i);k++)
                        {
                            salesList.get(salesIndex).addItem(donutB);
                        }
                        break;
                    case 2:
                        for (int k=0;k<QO.get(i);k++)
                        {
                            salesList.get(salesIndex).addItem(donutC);                   
                        }
                        break;
                    default:
                        for (int k=0;k<QO.get(i);k++)
                        {
                            salesList.get(salesIndex).addItem(donutD);
                        }
                        break;
                }
            }
            report.AddSales(salesList.get(salesIndex)); //add sales into report
            
            orderReport = new JFrame();     //window for order report (after submit)
            orderReport.setTitle("Donut Order Rrport");
            orderReport.setLayout(new FlowLayout());
            orderReport.setVisible(true);
            
            JPanel successOrder=new JPanel();
            
            JLabel successMessage=new JLabel("\nSuccessful Order");
            successMessage.setOpaque(true);
            successMessage.setFont(new Font("Times New Roman", Font.PLAIN, 30));
           
            JTextArea saleReport=new JTextArea(salesList.get(salesIndex).toString());   //generate report
            saleReport.setPreferredSize(new Dimension(450,450));

            successOrder.add(successMessage);
            orderReport.add(successOrder);
            orderReport.add(saleReport,BorderLayout.PAGE_END);
            orderReport.pack();
            orderWindow.dispose();      
            salesIndex++;   //sales index ++ when submit button press
        }
    }
    
    public static void main(String[] args)  {
          DonutSales donutSales = new DonutSales();
    }
}


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class PittChallenge {

    private double drugManPrice = 2.00;
    private String yourName;
    private int round = 0;
    private double yourMoney = 100.00;
    private int yourProd = 10;
    private double yourPrice = 0.00;
    private Business[] buss = new Business[4];
    private JFrame mainScreen;
    private JLabel[] busTitles = new JLabel[4];
    private JButton priceUp;
    private boolean ender = false;
    private JButton priceDown;
    private JButton confirm;
    private JLabel price;
    private JPanel[] busPanels = new JPanel[4];
    private JPanel botBottom = new JPanel();
    private JPanel beTop = new JPanel();
    private JPanel topper = new JPanel();
    private JPanel top = new JPanel();
    private JPanel middle = new JPanel();
    private JPanel bottom = new JPanel();
    private JLabel[] busMoney = new JLabel[4];
    private JLabel[] compPics = new JLabel[4];
    private JLabel[] busProd = new JLabel[4];
    private JLabel[] busPrice = new JLabel[4];
    private JLabel[] yourInfos = new JLabel[2];
    private JSeparator[] compSep = new JSeparator[4];
    private JLabel rounder;
    private Random ran = new Random();
    private int condition;
    private Clip music;
    private BufferedImage[] myPics = new BufferedImage[4];
    private JSeparator[] compSep2 = new JSeparator[4];
    private JLabel nameo;
    private UIManager UI = new UIManager();
    
    public static void main(String[] args) throws IOException {
        new PittChallenge();
    }
    public PittChallenge() throws IOException{
        myPics[0] = ImageIO.read(new File("pfi" + ".png"));
        myPics[1] = ImageIO.read(new File("joh" + ".png"));
        myPics[2] = ImageIO.read(new File("Nov" + ".png"));
        myPics[3] = ImageIO.read(new File("mer" + ".png"));
        UIManager.put("OptionPane.minimumSize",new Dimension(262,90));
        UIManager.put("OptionPane.background", Color.white);
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Arial", Font.BOLD, 15)));
        UI.put("Panel.background", Color.white);
        yourName = JOptionPane.showInputDialog(null, "What's your company's name?", "Company Name", JOptionPane.PLAIN_MESSAGE);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("for" + ".wav").getAbsoluteFile());
            music = AudioSystem.getClip();
            music.open(audioInputStream);
            music.start();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Error with playing sound.");
            ex.printStackTrace();
        }
        UIManager.put("OptionPane.minimumSize",new Dimension(1900,1040));
        UI.put("OptionPane.background",new ColorUIResource(100,100,100));
        UI.put("Panel.background", Color.BLACK);
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Courier", Font.BOLD, 60)));
        String intro = "<html><center><font color = 'white'>Welcome to the Pharmaceutical Showdown! <br/><br/><br/>Today, you will face off against some of the most well known <br/>and accomplished pharmaceutical companies on the planet! Luckily for you, <br/>      you're all starting with the same amount of money and resources! <br/>Choose your prices wisely, react to the market, and be the first to reach one thousand dollars <br/>in the sprawling pharmaceutical market!</font></center></html>";
        JLabel optionPane3 = new JLabel(intro, JLabel.CENTER);
        optionPane3.setFont(new Font("Courier", Font.BOLD, 30));
        JOptionPane.showMessageDialog(null, optionPane3, "Let's Begin!", JOptionPane.PLAIN_MESSAGE);
        buss[0] = new Business("Pfizer");
        buss[1] = new Business("Johnson & Johnson");
        buss[2] = new Business("Novartis");
        buss[3] = new Business("Merck & Co.");
        for(int i = 0; i < 4; i++){
            busPanels[i] = new JPanel();
            busPanels[i].setBackground(Color.BLACK);
            busPrice[i] = new JLabel("Price: " + "$" + String.valueOf(buss[i].getPrice()));
            busPrice[i].setFont(new Font("Courier", Font.BOLD, 30));
            busTitles[i] = new JLabel(buss[i].getName());
            busTitles[i].setFont(new Font("Courier", Font.BOLD, 30));
            busPanels[i].setLayout(new GridLayout(5,1));
            busMoney[i] = new JLabel("Money: " + String.valueOf(buss[i].getMoney()));
            busMoney[i].setFont(new Font("Courier", Font.BOLD, 30));
            busProd[i] = new JLabel("Products " + String.valueOf(buss[i].getProd()));
            busProd[i].setFont(new Font("Courier", Font.BOLD, 30));
            compSep[i] = new JSeparator(JSeparator.VERTICAL);
            compSep[i].setPreferredSize(new Dimension(50,200));
            compSep2[i] = new JSeparator(JSeparator.VERTICAL);
            compSep2[i].setPreferredSize(new Dimension(80,0));
            busTitles[i].setHorizontalAlignment(JLabel.CENTER);
            busMoney[i].setHorizontalAlignment(JLabel.CENTER);
            busProd[i].setHorizontalAlignment(JLabel.CENTER);
            busPrice[i].setHorizontalAlignment(JLabel.CENTER);
            compPics[i] = new JLabel(new ImageIcon(myPics[i]));
        }
        mainScreen = new JFrame("Pitt Challenge!");
        mainScreen.setSize(1920,1080);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setLayout(new GridLayout(6,1));
        String s = "Round " + String.valueOf(round);
        rounder = new JLabel(s);
        rounder.setForeground(Color.white);
        rounder.setFont(new Font("Courier", Font.BOLD, 70));
        rounder.setHorizontalAlignment(JLabel.CENTER);
        topper.add(rounder);
        topper.setBackground(Color.BLACK);
        mainScreen.add(topper);
        JSeparator vert1 = new JSeparator(JSeparator.HORIZONTAL);
        vert1.setPreferredSize(new Dimension(1000,1));
        middle.add(vert1);
        top.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());
        botBottom.setLayout(new FlowLayout());
        yourInfos[0] = new JLabel("Your money: " + String.valueOf(yourMoney) + "        ");
        yourInfos[1] = new JLabel("Your products: " + String.valueOf(yourProd));
        yourInfos[0].setFont(new Font("Courier", Font.BOLD, 45));
        yourInfos[1].setFont(new Font("Courier", Font.BOLD, 45));
        nameo = new JLabel(yourName + ":        ");
        nameo.setFont(new Font("Courier", Font.BOLD, 45));
        nameo.setForeground(Color.white);
        bottom.add(nameo);
        bottom.add(yourInfos[0]);
        JSeparator vert = new JSeparator(JSeparator.VERTICAL);
        vert.setPreferredSize(new Dimension(80,80));
        bottom.add(vert);
        beTop.setLayout(new FlowLayout());
        bottom.add(yourInfos[1]);
        for(int i = 0; i < 4; i++){
            beTop.add(compPics[i]);
            if(i < 3){
                beTop.add(compSep2[i]);
            }
            busPanels[i].add(busTitles[i]);
            busPanels[i].add(busMoney[i]);
            busPanels[i].add(busProd[i]);
            busPanels[i].add(busPrice[i]);
            top.add(busPanels[i]);
            if(i < 3){
                top.add(compSep[i]);
            }
        }
        price = new JLabel("$ 0.00   ");
        price.setFont(new Font("Courier", Font.BOLD, 60));
        priceUp = new JButton("Price Up");
        priceUp.setFont(new Font("Courier", Font.BOLD, 15));
        priceUp.setPreferredSize(new Dimension(150,100));
        priceUp.addActionListener(new ClickListener());
        priceDown = new JButton("Price Down");
        priceDown.setFont(new Font("Courier", Font.BOLD, 15));
        priceDown.setPreferredSize(new Dimension(150,100));
        priceDown.addActionListener(new ClickListener());
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Courier", Font.BOLD, 15));
        confirm.setPreferredSize(new Dimension(150,100));
        confirm.addActionListener(new ClickListener());
        beTop.setBackground(Color.BLACK);
        top.setBackground(Color.BLACK);
        middle.setBackground(Color.BLACK);
        botBottom.setBackground(Color.BLACK);
        bottom.setBackground(Color.BLACK);
        botBottom.add(price);
        botBottom.add(priceUp);
        botBottom.add(priceDown);
        botBottom.add(confirm);
        mainScreen.add(beTop);
        mainScreen.add(top);
        mainScreen.add(middle);
        mainScreen.add(bottom);
        mainScreen.add(botBottom);
        mainScreen.setVisible(true);
    }
    
    class ClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            // Using button for first login
            if(e.getSource() == priceUp){
                yourPrice += .50;
                price.setText("$ " + String.valueOf(yourPrice) + "   ");
            }
            if(e.getSource() == priceDown){
                yourPrice -= .50;
                if(yourPrice < 0){
                    yourPrice = 0;
                }
                price.setText("$ " + String.valueOf(yourPrice) + "   ");
            }
            if(e.getSource() == confirm){
                mainScreen.setVisible(false);
                int sold = 0;
                int yourSold = 0;
                int disNum = 2;
                double yourSoldMul = 1;
                double yourBuyMul = 1;
                int yourBought = 0;
                int bought = 0;
                double lowerMul = 1;
                double raiseMul = 1;
                double averagePrice = 0;
                for(int i = 0; i < 4; i++){
                    averagePrice += buss[i].getPrice();
                }
                averagePrice = averagePrice/4;
                JLabel optionPane = new JLabel("", JLabel.CENTER);
                optionPane.setFont(new Font("Courier", Font.BOLD, 30));
                condition = ran.nextInt(41);
                switch(condition){
                    case 0:
                        optionPane.setText("<html><center><font color = 'white'>Daraprim treats toxoplasmosis, which causes symptoms similar to the flu and <br/>can be passed to children through pregnancy.</font></center></html>");
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 1:
                        optionPane.setText("<html><center><font color = 'white'>Asthma rates rise across the country, increasing demand for Ventolin(Albuterol).</font></center></html>");
                        yourSoldMul = 1.3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 2:
                        optionPane.setText("<html><center><font color = 'white'>The 15 companies that control most of the pharmaceutical industry face new regulations, <br/>destabilizing prices for all patients.</font></center></html>");
                        disNum = 4;
                        lowerMul = 3;
                        raiseMul = 3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 3:
                        optionPane.setText("<html><center><font color = 'white'>The top selling presciption medication, Synthroid, which treats thyroid cancer and <br/>hypothyroidism, loses demand as a new treatmeant for thyroid cancer becomes available.</font></center></html>");
                        yourSoldMul = .7;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 4:
                        optionPane.setText("<html><center><font color = 'white'>A scientist strike leads to a lack of formulation during pharmaceutical <br/>manufacturing, drug supplies drop.</font></center></html>");
                        yourBuyMul = .6;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 5:
                        optionPane.setText("<html><center><font color = 'white'>A new form of granulation, where pharmaceutical drugs are formed through <br/>binding small particles together into granules, comes into prominence. Production soars.</font></center></html>");
                        yourBuyMul = 1.3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 6:
                        optionPane.setText("<html><center><font color = 'white'>The U.S. government passes a tax reformation act that reduces taxes on <br/>pharmaceutical sales, lowering prices.</font></center></html>");
                        lowerMul = 1.5;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 7:
                        optionPane.setText("<html><center><font color = 'white'>Bayer and Sanofi, two Big Pharma companies, merge to gain a greater hold <br/>on the market and prices stabilize with less competition.</font></center></html>");
                        lowerMul = .74;
                        raiseMul = 1.3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 8:
                        optionPane.setText("<html><center><font color = 'white'>NRTI drugs, which help patients with AIDs or HIV, see a hike in price <br/>as pharmaceutical companies realize that they can raise prices with minimum <br/>backlash, as this drug is necessary for survival.</font></center></html>");
                        raiseMul = 1.7;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 9:
                        optionPane.setText("<html><center><font color = 'white'>The British government decides to place strict regulations on <br/>pharmaceutical companies, creating instability.</html></font></center>");
                        disNum = 5;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 10:
                        optionPane.setText("<html><center><font color = 'white'>A new drug called Lutathera is approved by the FDA and hits <br/>worldwide markets, production and sales rise.</html></font></center>");
                        yourBuyMul = 1.4;
                        yourSoldMul = 1.3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 11:
                        optionPane.setText("<html><center><font color = 'white'>The FDA reviews Renova, a drug for reducing wrinkles and brown spots, <br/>and decides that it is unsafe for consumers. Production collapses.</font></center></html>");
                        yourBuyMul = .5;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 12:
                        optionPane.setText("<html><center><font color = 'white'>The opoid crisis strikes America, with people abusing presciption <br/>drugs such as Fentanyl, and eventually people resort to heroin <br/>when they run out of money or insurance. Sales soar.</font></center></html>");
                        yourSoldMul = 1.6;
                        raiseMul = 1.2;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 13:
                        optionPane.setText("<html><center><font color = 'white'>The modern pharmaceutical industry in the US began in 1818 when <br/>production switched to factories run by chemical manufacturers, <br/>rather than factories run by doctors and pharmacists.</font></center></html>");
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 14:
                        optionPane.setText("<html><center><font color = 'white'>New technology allows for video chats with doctors, so patients can <br/>receive prescriptions without visiting their hospital. Sales increase.</font></center></html>");
                        yourSoldMul = 1.3;
                        raiseMul = 1.2;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 15:
                        optionPane.setText("<html><center><font color = 'white'>A new paper in The New York Times reports that pharmaceutical companies <br/>paid off dozens of surgeons to sign off on false medical articles recommending <br/>their products. Sales plummet and instability occurs.</font></center></html>");
                        yourSoldMul = .7;
                        raiseMul = 1.6;
                        lowerMul = 1.6;
                        disNum = 8;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 16:
                        optionPane.setText("<html><center><font color = 'white'>In a new movie, the lead protagonist tries prescription pills after <br/>drinking, leading many teenagers to do the same.</font></center></html>");
                        yourSoldMul = 1.3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 17:
                        optionPane.setText("<html><center><font color = 'white'>A new tax limits imports on crucial ingredients for Lasix, a drug that <br/>treats edema and swelling, and prices rise.</font></center></html>");
                        raiseMul = 1.4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 18:
                        optionPane.setText("<html><center><font color = 'white'>A new form of Excel allows for better keeping of standard process sheets, <br/>increasing production.</font></center></html>");
                        yourBuyMul = 1.4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 19:
                        optionPane.setText("<html><center><font color = 'white'>New healthcare innovations allow for longer lifespans, drastically increasing <br/>an aging population's dependency on prescription drugs, <br/>so sales rise with prices.</font></center></html>");
                        yourSoldMul = 1.5;
                        raiseMul = 1.3;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 20:
                        optionPane.setText("<html><center><font color = 'white'>A new challenge, known as the Drop Pop Pill Challenge, stirs young adults to <br/>take a random pill from their medicine cabinet and try it.<br/> Sales rise.</font></center></html>");
                        yourSoldMul = 1.6;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 21:
                        optionPane.setText("<html><center><font color = 'white'>Backlash from the devastating Drop Pop Pill Challenge leads to a massive decline in sales <br/>for the pharmaceutical industry.</font></center></html>");
                        yourSoldMul = .4;
                        yourBuyMul = .7;
                        lowerMul = .7;
                        disNum = 4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 22:
                        optionPane.setText("<html><center><font color = 'white'>Colleges offer major scholarships for pharmacy students, increasing production.</font></center></html>");
                        yourBuyMul = 1.5;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 23:
                        optionPane.setText("<html><center><font color = 'white'>An increase in tuitions across American colleges lowers the rate of new <br/>chemical engineers, slowing development.</font></center></html>");
                        yourBuyMul = .8;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 24:
                        optionPane.setText("<html><center><font color = 'white'>CVS's across the world begin to close as local pharmacies grow. Instability arrises.</font></center></html>");
                        raiseMul = 1.2;
                        lowerMul = 1.2;
                        disNum = 4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 25:
                        optionPane.setText("<html><center><font color = 'white'>Merck, one of the first modern pharmaceutical companies, began by selling <br/>alkaloids such as morphine.</font></center></html>");
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 26:
                        optionPane.setText("<html><center><font color = 'white'>Global climate change leads to a decrease in available resources, hurting production <br/>in the pharmaceutical industry.</font></center></html>");
                        yourBuyMul = .7;
                        disNum = 5;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 27:
                        optionPane.setText("<html><center><font color = 'white'>A report on lying sales representatives from pharmaceutical companies <br/>is released, sending the industry into shock.</font></center></html>");
                        raiseMul = 1.4;
                        lowerMul = 1.4;
                        disNum = 7;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 28:
                        optionPane.setText("<html><center><font color = 'white'>The drug Flector, used for minor strains, sprains, and bruises is recalled <br/>after the FDA finds that it may cause cancer. Production falls.</font></center></html>");
                        yourBuyMul = .77;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 29:
                        optionPane.setText("<html><center><font color = 'white'>New medical research discovers that folic acid strongly discourages the formation of <br/>cancerous cells, leading to increased sales.</font></center></html>");
                        yourSoldMul = 1.4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 30:
                        optionPane.setText("<html><center><font color = 'white'>A new president declares that they will make America healthy again. Sales and <br/>instability rise.</font></center></html>");
                        yourSoldMul = 1.6;
                        disNum = 4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 31:
                        optionPane.setText("<html><center><font color = 'white'>Strict copyright laws allow for pharmaceutical patents to be protected for 20 years <br/>before any copies can be manufactured. Stability grows.</font></center></html>");
                        raiseMul = .6;
                        lowerMul = .6;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 32:
                        optionPane.setText("<html><center><font color = 'white'>When a startup pharmaceutical company innovates in the industry, the dominant <br/>corporations take a hit. They raise prices to defend themselves.</font></center></html>");
                        yourSoldMul = .8;
                        raiseMul = 1.6;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 33:
                        optionPane.setText("<html><center><font color = 'white'>An earthquake destroys pharmaceutical plants across the east coast of America, <br/>leading to decreased production.</font></center></html>");
                        yourBuyMul = .7;
                        disNum = 5;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 34:
                        optionPane.setText("<html><center><font color = 'white'>Singulair, a leukotriene inhibitor that reduces reactions to allergens, becomes <br/>more popular during allergy season.</font></center></html>");
                        yourSoldMul = 1.2;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 35:
                        optionPane.setText("<html><center><font color = 'white'>The global economy soars, with increases in sales in the industry.</font></center></html>");
                        yourSoldMul = 1.4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 36:
                        optionPane.setText("<html><center><font color = 'white'>A new documentary details how the FDA extensively tests animals for reactions to <br/>new drugs before giving them to humans. Prices fall.</font></center></html>");
                        yourSoldMul = .65;
                        lowerMul = 1.6;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 37:
                        optionPane.setText("<html><center><font color = 'white'>Chemical engineers discover a new way of milling, where particle sizes are reduced for <br/>drug creation, and production rises.</font></center></html>");
                        yourBuyMul = 1.4;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 38:
                        optionPane.setText("<html><center><font color = 'white'>Pharmaceutical managements collaborate to control prices, increasing stability and raising prices.</font></center></html>");
                        raiseMul = 1.3;
                        lowerMul = .67;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 39:
                        optionPane.setText("<html><center><font color = 'white'>Martin Shkreli is arrested, throwing the pharmaceutical industry into shock.</font></center></html>");
                        raiseMul = 1.3;
                        lowerMul = 1.3;
                        disNum = 7;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                    case 40:
                        optionPane.setText("<html><center><font color = 'white'>Early modern pharmaceutical companies, like Pfizer and Merck, were mostly formed by either Germans<br/> or German immigrants to the US.</font></center></html>");
                        yourSoldMul = .7;
                        raiseMul = 1.6;
                        lowerMul = 1.6;
                        disNum = 8;
                        JOptionPane.showMessageDialog(null, optionPane, "Important News", JOptionPane.PLAIN_MESSAGE);
                        condition = 0;
                        break;
                }
                for(int i = 0; i < 4; i++){
                    if(condition == 0){
                        if(buss[i].getPrice() <= averagePrice){
                            sold = 3*buss[i].getProd()/8 + ran.nextInt((buss[i].getProd()/2+1));
                        }
                        else if(buss[i].getPrice() < averagePrice*2){
                            sold = buss[i].getProd()/4 + ran.nextInt((buss[i].getProd()/3)+1) + (int)(yourSoldMul * buss[i].getProd()/8);
                        }
                        else if(buss[i].getPrice() < averagePrice*4){
                            sold = ran.nextInt((buss[i].getProd()/5+1)) + (int)(yourSoldMul * ran.nextInt(buss[i].getProd()/10+1));
                        }
                        else{
                            sold = (int)(yourSoldMul * 1);
                        }
                        buss[i].setMoney(sold * buss[i].getPrice());
                        bought += 5 + (int)(yourBuyMul * 5);
                        buss[i].setMoney(-1 * bought * drugManPrice);
                        buss[i].setProd(-1 * sold);
                        buss[i].setProd(bought);
                        if(bought > sold){
                            buss[i].setPrice(-1 * .2 + ran.nextDouble() * lowerMul);
                        }
                        else if(bought < sold){
                            buss[i].setPrice(.2 + ran.nextDouble() * raiseMul);
                        }
                        else{
                        }
                    }
                    sold = 0;
                    bought = 0;
                }
                if(yourPrice == 0){
                    yourSold = 0;
                }
                else if(yourPrice <= averagePrice){
                    yourSold = 3*yourProd/8 + ran.nextInt((yourProd/2)+1);
                }
                else if(yourPrice < averagePrice*1.2){
                    yourSold = yourProd/4 + ran.nextInt((yourProd/3)+1) + (int)(yourSoldMul * yourProd/8)  ;
                }
                else if(yourPrice < averagePrice*1.4){
                    yourSold = ran.nextInt((yourProd/5)+1) + (int)(yourSoldMul * ran.nextInt((yourProd/10)+1)) ;
                }
                else{
                    yourSold = 0;
                }
                yourMoney += yourSold * yourPrice;
                yourBought += 5 + (int)(yourBuyMul * 5);
                yourMoney -= yourBought * drugManPrice;
                yourProd -= yourSold;
                yourProd += yourBought;
                for(int i = 0; i < disNum; i++){
                    drugManPrice += ran.nextDouble();
                    drugManPrice -= ran.nextDouble();
                }
                round += 1;
                for(int i = 0; i < 4; i++){
                    busPrice[i].setText("Price: " + "$" + String.valueOf(round(buss[i].getPrice(),2)));
                    busMoney[i].setText("Money: " + String.valueOf(round(buss[i].getMoney(),2)));
                    busProd[i].setText("Products " + String.valueOf(buss[i].getProd()));
                }
                yourInfos[0].setText("Your money: " + String.valueOf(round(yourMoney,2)) + "        ");
                yourInfos[1].setText("Your products: " + String.valueOf(yourProd));
                String winner = "";
                int winners = 0;
                boolean win = false;
                for(int i = 0; i < 4; i++){
                    if(buss[i].getMoney() >= 1000){
                        win = true;
                        winner += buss[i].getName() + "($" + round(buss[i].getMoney(),2) + ")" + ", ";
                        winners++;
                    }
                }
                if(yourMoney >= 1000){
                        win = true;
                        winner += yourName + "($" + round(yourMoney,2) +") ";
                        winners++;
                }
                int choice = 0;
                JLabel choice2 = new JLabel("<html><font color =#239b56><center>Play Again???</center></font></html>", JLabel.CENTER);
                choice2.setFont(new Font("Courier", Font.BOLD, 60));
                if(win == true){
                    if(winners > 1){
                        String winner3 = "are the winners in Round ";
                        JLabel optionPane2 = new JLabel(winner + winner3 + round + "!", JLabel.CENTER);
                        optionPane2.setForeground(Color.YELLOW);
                        optionPane2.setFont(new Font("Courier", Font.BOLD, 20));
                        JOptionPane.showMessageDialog(null, optionPane2, "WINNER", JOptionPane.PLAIN_MESSAGE);
                        choice = JOptionPane.showConfirmDialog(null, choice2, "Again?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if(choice == JOptionPane.YES_OPTION){
                            music.stop();
                            try {
                                new PittChallenge();
                                ender = true;
                            } catch (IOException ex) {
                                Logger.getLogger(PittChallenge.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                    else{
                        winner +=  "is the winner in Round " + round + "!";
                        JLabel optionPane2 = new JLabel(winner, JLabel.CENTER);
                        optionPane2.setForeground(Color.YELLOW);
                        optionPane2.setFont(new Font("Courier", Font.BOLD, 60));
                        JOptionPane.showMessageDialog(null, optionPane2, "WINNER", JOptionPane.PLAIN_MESSAGE);
                        choice = JOptionPane.showConfirmDialog(null, choice2, "Again?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if(choice == JOptionPane.YES_OPTION){ 
                            music.stop();
                            try {
                                new PittChallenge();
                                ender = true;
                            } catch (IOException ex) {
                                Logger.getLogger(PittChallenge.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                }
                rounder.setText("Round " + round);
                if(ender == false){
                   mainScreen.setVisible(true);  
                }
                else{
                    
                }
            }
        }
    }
    
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

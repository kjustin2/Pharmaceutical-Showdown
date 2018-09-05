
/**
 *
 * @author kjust
 */
public class Business {
    private double money = 100.00;
    private int productCount = 10;
    private final String name;
    private double price = 5.00;
    
    public Business(String busName){
        name = busName;
    }
    
    public double getMoney(){
        return money;
    }
    
    public void setMoney(double change){
        money = money + change;
    }
    
    public int getProd(){
        return productCount;
    }
    
    public void setProd(int change){
        productCount = productCount + change;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double change){
        price = price + change;
    }
    
}

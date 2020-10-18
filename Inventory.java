import java.util.ArrayList;

public class Inventory {
    private int maxCapacity;
    ArrayList<Goods> goodsList =  new ArrayList<>();

    public Inventory(){
        this.maxCapacity = 0;
    }
    public Inventory(int capacity){
        this.maxCapacity = capacity;
    }

    private boolean isEmpty(){
        if(goodsList.size() < 1){
            return true;
        }
        return false;
    }

    private Goods searchGoods(Goods g){
        for(int i = (goodsList.size()-1); i >= 0; i--){
            if(goodsList.get(i) == g){
                return goodsList.get(i);
            }
        }
        return null;
    }

    private int searchGoodLocation(Goods g){
        for(int i = (goodsList.size()-1); i >= 0; i--){
            if(goodsList.get(i) == g){
                return i;
            }
        }
        return -1;
    }


    public int currentCapacity(){
        if(isEmpty()){
            return 0;
        }

        int cc = 0;
        for(int i=0; i<goodsList.size(); i++){
            cc += goodsList.get(i).getWeight();
        }
        return cc;
    }

    public boolean addGoods(Goods g){
        int totalCapacity = currentCapacity() + g.getWeight();
        if(this.maxCapacity < totalCapacity){
            return false;
        }
        goodsList.add(g);
        return true;
    }

    public void  listGoods(){
        if(isEmpty()){
            System.out.println("Nothing to show");
        }
        else{
            for(int i=0; i<goodsList.size(); i++){
                goodsList.get(i).info();
            }
        }
    }

    public boolean checkGoodsStatus(Goods g){
        return this.searchGoods(g).isDangerous();
    }

    public boolean removeGoods(Goods g, int c){
        if(isEmpty()){
            return false;
        }

        try {
            this.searchGoods(g).destroy(c);
            goodsList.remove(this.searchGoodLocation(g));
            return true;
        } catch (Exception e) {
            System.out.println("Failed to destroy item, certificate does't match");
        }

        return true;
    }

    public int getTotalBenefit(){
        int total = 0;
        for(int i=0; i<goodsList.size(); i++){
            total += goodsList.get(i).storePrice();
        }
        return total;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}

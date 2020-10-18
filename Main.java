import java.util.ArrayList;
import java.util.Scanner; 

public class Main {
    static private Scanner s = new Scanner(System.in);
    static Inventory pocket = new Inventory();
    static ArrayList <Goods> listGoods =  new ArrayList<>();
    static int goodId = 0;

    // this function suppose to be in another class
    private static Goods searchMenu(int idGood){
        if(listGoods.isEmpty()){
            System.out.println("Nothing is found");
            return null;
        }

        for(int i = (listGoods.size()-1); i >= 0; i--){
            int tempId = listGoods.get(i).getId();
            if(idGood == tempId){
                return listGoods.get(i);
            }
        }

        System.out.println("Nothing is found");
        return null;
    }

    private static void doMenu(){
        int cm;
        String yOrN = "y";

        // Goods variable
        int i;
        Goods g = null;
        String merk;
        int price, weight, cer, Idgood;

        System.out.println("================================");
        System.out.println("1. add goods");
        System.out.println("2. show goods list");
        System.out.println("3. add goods to inventory");
        System.out.println("4. remove goods from inventory");
        System.out.println("5. list all goods inside inventory");
        System.out.println("6. show inventory profit");
        System.out.println("================================");
        System.out.println("Choose Menu :");
        cm = s.nextInt();
        s.nextLine();
        
        // give a bunch  of switch
        // bad way to code i think. LOL :)
        switch(cm) {
            //add goods
            case 1:
                System.out.println("-- Add Goods --");
                System.out.print("What's your good ?      :");
                merk = s.nextLine();
                System.out.print("How much it costs?      :");
                price = s.nextInt();
                System.out.print("how heavy? (ton)        :");
                weight = s.nextInt();
                s.nextLine();
                System.out.print("Is it dangerous [y/n] ? :");
                yOrN = s.nextLine();

                
                // id good is dangerous
                if(yOrN.equals("y")){
                    // Add Dangerous Goods
                    System.out.print("Enter certificate number :");
                    cer = s.nextInt();
                    s.nextLine();
                    // goodId is automaticly generate
                    g = new GoodsDangerous(goodId, merk, price, weight, cer);
                }else{
                    //Add General goods
                    g = new GoodsGeneral(goodId, merk, price, weight);
                }
                goodId++;
                listGoods.add(g);

            break;
            case 2:
                System.out.println("-- list Goods --");
                System.out.println("Id | Merk | price | weight");
                for(i = 0; i< listGoods.size(); i++){
                    listGoods.get(i).info();
                }
            break;
            case 3:
                System.out.println("-- Add Goods to Inventory --");
                System.out.print("What's your good id ?   :");
                //Idgood is not automaticlt generate
                Idgood = s.nextInt();
                s.nextLine();
                if(searchMenu(Idgood) != null){
                    if(pocket.addGoods(searchMenu(Idgood))){
                        System.out.println("-> add goods sucess");
                    }
                    else{
                        System.out.println("!! inventory is full");
                    }
                }
            break;
            case 4:
                System.out.println("-- Remove Goods from Inventory --");
                System.out.print("What's your good id ?   :");
                //Idgood is not automaticlt generate
                Idgood = s.nextInt();
                s.nextLine();
                Goods good = searchMenu(Idgood);
                if(good != null){
                    if(pocket.checkGoodsStatus(good)){
                        System.out.print("Enter certificate number :");
                        int c = s.nextInt();
                        s.nextLine();
                        pocket.removeGoods(good,c);
                    }else{
                        pocket.removeGoods(good,0);
                    }
                }
                
            break;
            case 5:
                System.out.println("-- List Goods from Inventory --");
                System.out.println("Id | Merk | price | weight | profit");
                pocket.listGoods();
            break;
            case 6:
                System.out.println("-- Inventory Profit --");
                System.out.println(pocket.getTotalBenefit());
            break;
            default:
                System.out.println("Nothing to do");
            break;
        }
    }

    public static void main(String[] args) {
        String userName;
        int inventoryCapacity;
        String isContinue = "y";

        System.out.println("Welcome to inventory management !!");
        System.out.println("What's your name ? ");
        userName = s.nextLine();
        System.out.println("Hello," + userName);
        System.out.println("How many good you want to store in ton ? ");
        inventoryCapacity = s.nextInt();
        s.nextLine();
        pocket.setMaxCapacity(inventoryCapacity);
        
        //looping an do
        while(isContinue.equals("y")){
            doMenu();
            System.out.print("Continue ? [y/n] :");
            isContinue = s.next();
        }
        
    }

    
}
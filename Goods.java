abstract class Goods{
    String merk;
    int weight;
    int price;
    // i am sick of java string
    int id;


    abstract int storePrice();
    abstract boolean isDangerous();
    abstract void destroy(int cer);

    public void info(){
        System.out.println(this.id + "|" + this.merk + " | "+this.weight+ " | "+this.price+" | "+this.storePrice());
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPrice() {
        return this.price;
    }
    public String getMerk(){
        return this.merk;
    }
    public int getId(){
        return this.id;
    }

}
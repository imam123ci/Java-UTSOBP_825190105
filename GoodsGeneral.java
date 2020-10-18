class GoodsGeneral extends Goods{
    public GoodsGeneral(int id, String merk, int price, int weight){
       this.id = id;
       this.merk = merk; 
       this.price = price;
       this.weight = weight;
   }
   
   public int storePrice(){
       return(this.weight * 2);
   }

   public boolean isDangerous(){
    return false;
    }

   public void destroy(int cer){
       System.out.println("Destroying " + this.merk);
   }
}
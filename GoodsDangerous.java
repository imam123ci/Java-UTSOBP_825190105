public class GoodsDangerous extends Goods {
    private int certificate;

    public GoodsDangerous(int id, String merk, int price, int weight, int certificate){
        this.id = id;
        this.merk = merk; 
        this.price = price;
        this.weight = weight;
        this.certificate = certificate;
    }

    public int storePrice(){
        return( this.weight * this.price * 2);
    }

    public boolean isDangerous(){
        return true;
    }

    public void destroy(int cer){
        if(cer == this.certificate){
            System.out.println("Boom shaka2 bom bom - " + this.merk);
        }else{
            System.out.println("Certificate number does't match");
            throw new RuntimeException("Certificate doesn't match");
        }
    }
}

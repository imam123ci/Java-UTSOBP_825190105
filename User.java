class User{
    private String name;


    User(String name) {
        this.name = name;
    }

    public boolean SignIn(String name){
        // Seharusnya mengecek kredensial user
        System.out.println("Log in .... success");
        return true;
    }

    public String getName() {
        return this.name;
    }


    

}

package my_package;

public class Stone extends Item{
    protected String color;

    public Stone(String name, double weight, String color){
        super(name,weight);
        this.color = color;
        if (color.equals("black"))
            this.value = 3;
        else if (color.equals("white"))
            this.value = 2;
        else
            this.value = 1;
    }

    @Override
    public void look_at() {
        System.out.println("It's just a stone. But some people may pay you for any unusual stones...");
    }
}

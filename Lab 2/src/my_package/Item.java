package my_package;

public class Item extends GameObject implements Pickable {
    protected double weight;
    protected double value;

    public Item(){};

    public Item(String name, double weight){
        super(name);
        this.weight = weight;
        this.value = 0;
    }

    public Item(String name, double weight, double value){
        super(name);
        this.weight = weight;
        this.value = value;
    }

    public Pickable pick_up() {
        return this;
    }

    public double get_weight() {
        return this.weight;
    }

    public double get_value() {
        return this.value;
    }

    public String get_extra(){
        return "nothing";
    }
}

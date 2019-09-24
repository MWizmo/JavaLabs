package my_package;

public abstract class GameObject implements Lookable {
    protected String name;

    public GameObject(){}

    public GameObject(String _name){
        this.name = _name;
    }

    public void look_at(){
        System.out.println("You look at " + this.name);
    }

    public void inspect() {
        System.out.println("You don't see anything remarkable");
    }

    public String get_name(){
        return this.name;
    }
}

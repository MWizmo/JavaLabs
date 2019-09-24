package my_package;

public class Key extends Item {
    protected int door_id;

    public Key(String name, int door_id){
        super(name,0,0);
        this.door_id = door_id;
    }

    public int get_door_id(){
        return this.door_id;
    }

    @Override
    public void inspect() {
        System.out.printf("You see strange digits on this key. It's %d\n", this.door_id);
    }

    @Override
    public void look_at() {
        System.out.println("Beautiful metallic key");
    }

    @Override
    public String get_extra(){
        return "digits on it (" + this.door_id + ")";
    }
}

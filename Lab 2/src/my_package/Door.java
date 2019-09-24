package my_package;

public class Door extends GameObject {
    private int door_id;

    public Door(String name, int door_id){
        super(name);
        this.door_id = door_id;
    }

    public int get_door_id(){
        return this.door_id;
    }

    @Override
    public void inspect() {
        System.out.printf("You decided to inspect lock at this door. You see small digits: %d\n", this.door_id);
    }

    @Override
    public void look_at() {
        System.out.println("Huge iron door. It's closed.");
    }
}

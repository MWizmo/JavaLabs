package my_package;

public class Player {
    private String name;
    private Pickable[] inventory;
    private int count;

    public Player(){
        this.name = "Player";
        this.inventory = new Pickable[10];
        this.count = 0;
    }

    public void pick_up(Pickable item){
        if(this.count<9){
            this.inventory[this.count] = item.pick_up();
            this.count ++;
            System.out.printf("You picked %s. Weight: %f, value: %f\n", item.get_name(), item.get_weight(), item.get_value());
        }
        else
            System.out.println("Your inventory is full");
    }

    public void speak_with(Speakable somebody){
        somebody.speak();
    }

    public void ask_question_to(Speakable somebody){
        somebody.ask_question();
    }

    public void look_at(Lookable anything){
        anything.look_at();
    }

    public void inspect(Lookable anything){
        anything.inspect();
    }

    public boolean try_open_door(Door door){
        int door_id = door.get_door_id();
        for(Pickable item: this.inventory){
            if(item instanceof Key){
                if (door_id == ((Key) item).get_door_id()){
                    return true;
                }
            }
        }
        return false;
    }

    public void show_inventory(){
        if(this.count == 0) {
            System.out.println("Inventory is empty");
        }
        else{
            System.out.println("Your inventory:");
            for (int i=0; i<this.count; i++)
                System.out.printf("Item: %s. Weight: %f. Value: %f. Some extra: %s\n",
                        this.inventory[i].get_name(), this.inventory[i].get_weight(),
                        this.inventory[i].get_value(), this.inventory[i].get_extra());
            }
        }

    public void move(){
        System.out.println("You went to other location");
    }
}

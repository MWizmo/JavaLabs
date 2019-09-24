import my_package.*;

public class Program {
    public static void main(String[] args){
        Player player = new Player();
        player.move();
        Human tom = new Human("Tom", 30);
        player.look_at(tom);
        player.speak_with(tom);
        player.ask_question_to(tom);
        player.inspect(tom);
        System.out.println();

        player.move();
        Item stick = new Item("Stick", 12.2);
        player.look_at(stick);
        player.inspect(stick);
        player.show_inventory();
        player.pick_up(stick);
        player.show_inventory();

        System.out.println();
        player.move();
        Key key = new Key("Golden key", 12);
        player.inspect(key);
        player.pick_up(key);
        player.show_inventory();

        System.out.println();
        player.move();
        Human bill = new Citizen("Bill", 53);
        player.look_at(bill);
        player.speak_with(bill);
        player.ask_question_to(bill);
        player.inspect(bill);

        System.out.println();
        player.move();
        Item stone = new Stone("Small stone", 2.1, "white");
        player.look_at(stone);
        player.pick_up(stone);
        player.show_inventory();

        System.out.println();
        player.move();
        Door door = new Door("Golden door", 12);
        player.look_at(door);
        player.inspect(door);
        if(player.try_open_door(door)){
            System.out.println("You opened final door. Congratulations!");
        }
        else{
            System.out.println("Door is still closed");
        }
    }
}

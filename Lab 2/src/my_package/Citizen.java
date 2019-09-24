package my_package;

public class Citizen extends Human{
    public Citizen(String name, int age){
        super(name, age);
    }

    @Override
    public void speak(){
        System.out.println("You ask: \"Who are you?\"\n\"I am " + this.name +"\" and I live in this city");
    }

    @Override
    public void ask_question() {
        System.out.println("You ask:\"What time is it now?\"\n\"It's always midnight!\"");
    }

    @Override
    public void inspect(){
        System.out.println("You look at citizen. Something haunts you, but you can't recognise cause of it. Strange city.");
    }
}

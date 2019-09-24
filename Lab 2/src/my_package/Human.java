package my_package;

public class Human extends GameObject  implements Speakable{
    protected int age;

    public Human(){};

    public Human(String name, int age){
        super(name);
        this.age = age;
    }

    public int get_age(){
        return this.age;
    }

    @Override
    public void look_at(){
        String str = "You see ";
        if (this.age < 25)
            str += "young ";
        else if (this.age < 50)
            str += "adult ";
        else
            str += "old ";
        str += "human.";
        System.out.println(str);
    }

    @Override
    public void inspect() {
        System.out.println("Just usual human");
    }

    public void speak(){
        System.out.println("You ask: \"What's your name?\"\n\"My name is " + this.name +"\"");
    }

    public void ask_question() {
        System.out.println(this.name + " can't answer your questions");
    }
}

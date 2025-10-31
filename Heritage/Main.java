package Heritage;

public class Main {
    public static void main(String[]args){
        Chien chien = new Chien(14);
        System.out.println(chien.age);
        chien.aboyer();

        Chat chat = new Chat(4);
        System.out.println(chat.age);
        chat.miauler();
    }
}

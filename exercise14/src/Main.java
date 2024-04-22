import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("JSON with gson example");
        serializeSimple();
        //deserializeSimple();

    }

    static void serializeSimple() {

        Todos losdias = new Todos("Walk the dog", false, 0, 3, "dog");
        Todos t2 = new Todos("Pay the bills", true, 1, 1,"bills");

        ArrayList<Todos> todosList = new ArrayList<>();
        todosList.add(losdias);
        todosList.add(t2);

        Gson gson = new Gson();
        try(FileWriter fw = new FileWriter("data.json"))
        {
            gson.toJson(todosList,fw);
            System.out.println(todosList);

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void deserializeSimple(){
        try(FileReader fr = new FileReader("data.json")) {
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(fr);
            Gson gson = new Gson();
            Todos t1 = gson.fromJson(element,Todos.class);
            System.out.println(t1);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

class Simple {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;

    public Simple(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
class Todos{
    private String body;
    private boolean isDone;
    private int id;
    private int priority;
    private String title;

    public Todos(String body, boolean isDone, int id, int priority, String title) {
        this.body = body;
        this.isDone = isDone;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "body='" + body + '\'' +
                ", isDone=" + isDone +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}
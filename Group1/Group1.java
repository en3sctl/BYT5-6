package Group1;
import java.util.ArrayList;
import java.util.List;

//mediator interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

//concrete Mediator
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl(){
        this.users=new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for(User u : users){
            if(u != user){
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

//colleague interface
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name){
        this.mediator=mediator;
        this.name=name;
    }

    abstract void send(String message);
    abstract void receive(String message);
}

//concrete colleague
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void send(String message) {
        System.out.println(name+ " sends: "+ message);
        mediator.sendMessage(message, this);
    }

    @Override
    void receive(String message) {
        System.out.println(name+ " receives: "+ message);
    }

//main class
    public class MediatorPatternExample {
        public static void main(String[] args) {
            ChatMediator mediator = new ChatMediatorImpl();
    
            User user1 = new ChatUser(mediator, "Enes");
            User user2 = new ChatUser(mediator, "Recep");
            User user3 = new ChatUser(mediator, "Arda");
    
            mediator.addUser(user1);
            mediator.addUser(user2);
            mediator.addUser(user3);
    
            user1.send("Hello, everyone!");
        }
    }
}



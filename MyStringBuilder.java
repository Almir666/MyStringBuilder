import java.util.LinkedList;

public class MyStringBuilder {

    private String value = "";
    private LinkedList<Snapshot> snapshots = new LinkedList<>();

    public MyStringBuilder(){
        snapshots.push(new Snapshot(new String(value)));
    }

    public MyStringBuilder(String str) {
        value += str;
        snapshots.push(new Snapshot(new String(value)));
    }

    public void append(String str) {
        value += str; 
        snapshots.push(new Snapshot(new String(value)));
    }

    public void undo() {
        if(!snapshots.isEmpty()) {
            snapshots.pop();
            value = new String(snapshots.peekFirst().getState());
            
        }
    }

    @Override
    public String toString() {
        return value;
    }

    public static void main(String[] args) {
        MyStringBuilder str = new MyStringBuilder();

        str.append("text");
        str.append(" + data");
        str.append(" + awrgrg");
        str.undo();
        str.undo();

        
        System.out.println(str);
    }


    static class Snapshot {
        private final String state;

        public Snapshot(String newState) {
            state = newState;
        }
        
        public String getState() {
            return state;
        }
    }
}


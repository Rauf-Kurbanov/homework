package main;

import java.util.Timer;
import java.util.TimerTask;

public class Network {
    
    public static void main(String[] args){
        byte[][] connections = {
            {0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 1, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 1, 0, 0}
        };        
        Computer[] users = new Computer[9];
        users[0] = new Computer(new Windows(), true);
        users[1] = new Computer(new Windows(), false);
        users[2] = new Computer(new Linux(), false);
        users[3] = new Computer(new Linux(), false);
        users[4] = new Computer(new Mac(), false);
        users[5] = new Computer(new Mac(), false);
        users[6] = new Computer(new Windows(), false);
        users[7] = new Computer(new Windows(), false);
        users[8] = new Computer(new Windows(), true);
        
        Network network = new Network(connections, users);
        network.start();
    }

    public Network(byte[][] connections, Computer[] users) {
        this.size = connections.length;
        this.users = users;
        this.connections = connections;
    }
    
    public void start() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                update();
                System.out.println(printState());
            }
        };

        timer.schedule(task, 1000, 1000);
    }
    
    public String printState() {
        int k = 0;
        for (int i = 0; i < size; ++i) {
            if (users[i].isInfected())
                k ++;
        }
        return k * 100 /size + "% infected";
    }
    
    private void update() {
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (connections[i][j] > 0) {
                    users[i].attack(users[j]);
                }
            }

        }
        for (int i = 0; i < size; ++i) {
            if (users[i].isInjured()) {
                users[i].infect();
            }
        }
    }
    
    private int size;
    
    private Computer[] users;
    
    private byte[][] connections;
}

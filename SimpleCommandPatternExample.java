// Command interface
interface Command {
    void execute();
}

// Receiver classes
class Light {
    void on() {
        System.out.println("Light is ON");
    }

    void off() {
        System.out.println("Light is OFF");
    }
}

class CeilingFan {
    void on() {
        System.out.println("Ceiling Fan is ON");
    }

    void off() {
        System.out.println("Ceiling Fan is OFF");
    }
}

// Concrete Command classes
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class CeilingFanOnCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }
}

class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

// Main class to test the command pattern
public class SimpleCommandPatternExample {
    public static void main(String[] args) {
        // Create receivers
        Light light = new Light();
        CeilingFan ceilingFan = new CeilingFan();

        // Create commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new CeilingFanOnCommand(ceilingFan);
        Command fanOff = new CeilingFanOffCommand(ceilingFan);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Test Light Commands
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.setCommand(lightOff);
        remote.pressButton();

        // Test Ceiling Fan Commands
        remote.setCommand(fanOn);
        remote.pressButton();
        remote.setCommand(fanOff);
        remote.pressButton();
    }
}

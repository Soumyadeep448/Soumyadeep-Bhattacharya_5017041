public interface Notifier {
    void send(String message);
}

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

public abstract class NotifierDecorator implements Notifier {
    protected Notifier decoratedNotifier;

    public NotifierDecorator(Notifier decoratedNotifier) {
        this.decoratedNotifier = decoratedNotifier;
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
    }
}

public abstract class NotifierDecorator implements Notifier {
    protected Notifier decoratedNotifier;

    public NotifierDecorator(Notifier decoratedNotifier) {
        this.decoratedNotifier = decoratedNotifier;
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
    }
}

public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message); 
        sendSMS(message); 
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message); 
        sendSlack(message); 
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message with message: " + message);
    }
}


public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier slackSMSEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        slackSMSEmailNotifier.send("Hello, this is a test notification!");
    }
}


public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier slackSMSEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        slackSMSEmailNotifier.send("Hello, this is a test notification!");
    }
}

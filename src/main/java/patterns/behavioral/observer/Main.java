package patterns.behavioral.observer;

public class Main {

    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        Channel channel = new Channel();
        newsAgency.addObserver(channel);
        System.out.println(channel.getNews());
        newsAgency.setNews("Breaking news!!!");
        System.out.println(channel.getNews());

        PCSNewsAgency pcsNewsAgency = new PCSNewsAgency();
        PCLChannel pclChannel = new PCLChannel();
        pcsNewsAgency.addPropertyChangeListener(pclChannel);
        System.out.println(pclChannel.getNews());
        pcsNewsAgency.setNews("Another breaking news!!");
        System.out.println(pclChannel.getNews());
    }
}

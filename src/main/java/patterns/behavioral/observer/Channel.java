package patterns.behavioral.observer;

public class Channel {

    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public void update(Object news) {
        this.setNews((String) news);
    }
}

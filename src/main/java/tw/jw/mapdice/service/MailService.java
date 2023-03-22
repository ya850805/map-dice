package tw.jw.mapdice.service;

public interface MailService {
    void send(String to, String title, String content);
}

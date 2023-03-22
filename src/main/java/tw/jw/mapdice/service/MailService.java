package tw.jw.mapdice.service;

import javax.mail.MessagingException;

public interface MailService {
    void send(String to, String title, String content);
    void sendHtml(String to, String title, String content) throws MessagingException;
}

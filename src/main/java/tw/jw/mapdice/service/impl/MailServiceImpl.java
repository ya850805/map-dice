package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.service.MailService;
import tw.jw.mapdice.service.UsersService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UsersService usersService;

    @Value("${mail.from}")
    private String from;

    @Override
    public void send(String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        javaMailSender.send(message);
    }

    @Override
    public void sendHtml(String to, String title, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(title);
        helper.setText(content, true);
        javaMailSender.send(message);
    }

    @Override
    public void sendForgotPassword(String email) {
        if(Objects.isNull(usersService.getByEmail(email))) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "email not exist");
        }

        //TODO 生成忘記密碼並修改密碼的地址，放入redis 5分鐘失效
    }
}

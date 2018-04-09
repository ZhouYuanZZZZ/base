package com.zy.test;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class MailTest {

    public static void main(String[] args) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
        email.setHostName("182.18.63.131");
        // 字符编码集的设置
        email.setCharset("UTF-8");
        // 收件人的邮箱
        email.addTo("willzhou@csscaps.com");
        // 发送人的邮箱
        email.setFrom("tsc@csscaps.com", "senderName");
        // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
        email.setAuthentication("tsc@csscaps.com", "a123456");
        // 要发送的邮件主题
        email.setSubject("主题");
        // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
        email.setMsg("正文");

        email.setSmtpPort(25);

        EmailAttachment attachment =new EmailAttachment();
        attachment.setPath("C:\\Users\\zy127\\Downloads\\26006-1000001118.pdf");// 本地文件
        // attachment.setURL(new URL("http://xxx/a.gif"));//远程文件
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("26006-1000001118.pdf");
        attachment.setName("26006-1000001118.pdf");

        email.attach(attachment);
        email.send();

        System.out.println("1");
    }
}

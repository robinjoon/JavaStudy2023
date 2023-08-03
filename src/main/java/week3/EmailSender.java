package week3;

import week3.dto.EmailData;

public interface EmailSender {
    void sendEmail(EmailData data);
}

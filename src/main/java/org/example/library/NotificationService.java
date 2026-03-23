package org.example.library;

public class NotificationService {
    public void sendNotification(String username, String title) {
        System.out.println("Notifikasi dikirim ke " + username + " untuk buku: " + title);
    }
}
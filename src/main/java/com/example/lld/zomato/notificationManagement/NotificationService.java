package com.example.lld.zomato.notificationManagement;

import com.example.lld.zomato.userManagement.User;

public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(User user, String message) {
        System.out.println("Notification to " + user.getName() + ": " + message);
    }
}

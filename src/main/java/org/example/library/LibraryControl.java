package org.example.library;

public class LibraryControl {
    private LibraryModel model;
    private NotificationService notificationService;

    public LibraryControl(LibraryModel model, NotificationService notificationService) {
        this.model = model;
        this.notificationService = notificationService;
    }

    public boolean cekKetersediaan(int id) {
        return model.isBookAvailable(id);
    }

    public void pinjamBuku(int id, String title, String username) {
        if (model.isBookAvailable(id)) {
            model.getAllBooks();
            model.borrowBook(title, username);
            notificationService.sendNotification(username, title);
        }
    }
}
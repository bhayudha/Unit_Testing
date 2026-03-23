package org.example.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryControlTest {

    @Mock
    private LibraryModel bookModel;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private LibraryControl control;

    @Test
    void testCekKetersediaan() {
        when(bookModel.isBookAvailable(1)).thenReturn(true);

        assertTrue(control.cekKetersediaan(1));
        verify(bookModel).isBookAvailable(1);
    }

    @Test
    void testPinjamBuku_Sukses() {
        int id = 1;
        String title = "Java Testing";
        String user = "Mahasiswa";

        when(bookModel.isBookAvailable(id)).thenReturn(true);

        control.pinjamBuku(id, title, user);

        InOrder inOrder = inOrder(bookModel, notificationService);
        inOrder.verify(bookModel).getAllBooks();
        inOrder.verify(bookModel).borrowBook(title, user);
        inOrder.verify(notificationService).sendNotification(user, title);
    }

    @Test
    void testPinjamBuku_Gagal_SedangDipinjam() {
        int id = 2;
        when(bookModel.isBookAvailable(id)).thenReturn(false);

        control.pinjamBuku(id, "Buku Lain", "User X");

        verify(bookModel, never()).borrowBook(anyString(), anyString());
        verify(notificationService, never()).sendNotification(anyString(), anyString());
    }
}
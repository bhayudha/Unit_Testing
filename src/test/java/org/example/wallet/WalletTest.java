package org.example.wallet;

import org.example.Owner;
import org.example.Wallet;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

@Disabled("Fokus pada tugas Mockito")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet();
    }

    @Test
    @Order(1)
    void testSetOwner() {
        Owner ownerBaru = new Owner("1", "Gadjah Mada", "mada@ugm.ac.id");
        wallet.setOwner(ownerBaru);
        assertEquals("Gadjah Mada", wallet.getOwner().getName());
    }

    @Test
    void testCardFunctionality() {
        wallet.addCard("KTP");
        wallet.addCard("ATM Mandiri");
        assertEquals(2, wallet.getCards().size());

        boolean removed = wallet.removeCard("KTP");
        assertTrue(removed);
        assertEquals(1, wallet.getCards().size());
    }

    @Test
    void testCashFunctionality() {
        wallet.addCash(50000);

        // Withdraw Valid
        assertDoesNotThrow(() -> wallet.withdrawCash(20000));
        assertEquals(30000, wallet.getCashBalance());

        // Withdraw Melebihi Saldo (Harus Throw Exception, bukan return false)
        assertThrows(RuntimeException.class, () -> wallet.withdrawCash(100000));
    }
}
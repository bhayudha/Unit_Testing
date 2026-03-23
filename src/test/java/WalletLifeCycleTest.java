package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletLifeCycleTest {
    private static Wallet sharedWallet;

    @BeforeAll
    static void setupDatabaseOrExternalResource() {
        sharedWallet = new Wallet();
    }

    @BeforeEach
    void resetWalletState() {
        sharedWallet.setOwner(null);
    }

    @Test
    @Order(1)
    void testSetOwner() {
        Owner ownerBaru = new Owner("1945", "Gadjah Mada", "ugm@mail.com");
        sharedWallet.setOwner(ownerBaru);
        assertEquals("Gadjah Mada", sharedWallet.getOwner().getName());
    }

    @Test
    @Order(2)
    void testAddCashAccumulation() {
        sharedWallet.addCash(100000);
        assertEquals(100000, sharedWallet.getCashBalance(), 0.0);
    }

    @Test
    @Order(3)
    void testWithdrawFromPreviousBalance() {
        sharedWallet.withdrawCash(40000);
        assertEquals(60000, sharedWallet.getCashBalance(), 0.0);
    }

    @AfterAll
    static void tearDown() {
        sharedWallet = null;
    }
}
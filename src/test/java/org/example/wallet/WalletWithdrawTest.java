package org.example.wallet;

import org.example.Wallet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource; // Ini dia library-nya
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

@Disabled("Fokus pada tugas Mockito")
class WalletWithdrawTest {
    @ParameterizedTest
    @ValueSource(ints = {10000, 20000})
    void testDepositValid(int amount) {
        Wallet wallet = new Wallet();
        wallet.addCash((double) amount);
        assertTrue(wallet.getCashBalance() > 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5000, -10000})
    void testDepositInvalid(int amount) {
        Wallet wallet = new Wallet();
        assertThrows(IllegalArgumentException.class, () -> wallet.addCash((double) amount));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid-withdraw.csv")
    void testWithdrawValid(int deposit, int withdraw, int expect) {
        Wallet wallet = new Wallet();
        wallet.addCash((double) deposit);
        wallet.withdrawCash((double) withdraw);
        assertEquals((double) expect, wallet.getCashBalance(), 0.0);
    }
}
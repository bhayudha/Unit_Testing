package org.example.wallet;

import org.example.Owner;
import org.example.Wallet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

@Disabled("Fokus pada tugas Mockito")
class WalletOwnerTest {
    private static Stream<Arguments> provideOwnerData() {
        return Stream.of(
                Arguments.of(new Owner("1", "User A", "a@mail.com")),
                Arguments.of(new Owner("2", "User B", "b@mail.com"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideOwnerData")
    void testSetOwner(Owner ownerParam) {
        Wallet wallet = new Wallet();
        wallet.setOwner(ownerParam);
        assertNotNull(wallet.getOwner());
        assertEquals(ownerParam.getName(), wallet.getOwner().getName());
    }
}
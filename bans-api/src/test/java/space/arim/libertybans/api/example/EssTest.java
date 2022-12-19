package space.arim.libertybans.api.example;

import org.junit.jupiter.api.Test;
import space.arim.libertybans.bootstrap.depend.Dependency;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EssTest {

        private final byte[] bytes = randomBytes();

        private static byte[] randomBytes() {
            Random r = ThreadLocalRandom.current();
            byte[] array = new byte[r.nextInt(20)];
            r.nextBytes(array);
            return array;
        }

        @Test
        public void testConversions() {
            String asHex = Dependency.bytesToHex(bytes);
            byte[] backToBytes = Dependency.hexStringToByteArray(asHex);
            assertArrayEquals(bytes, backToBytes);
            assertEquals(asHex, Dependency.bytesToHex(backToBytes));
        }

    }

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class BootCampKtTest {

    @Test
    fun 入力例_1() {
        val input =
                "4 5 7" + System.lineSeparator() +
                        "1011"
        val output =
                "12"

        assertIO(input, output);
    }

    @Test
    fun 入力例_2() {
        val input =
                "4 4 10" + System.lineSeparator() +
                        "0101"
        val output =
                "8"

        assertIO(input, output);
    }

    @Test
    fun 入力例_3() {
        val input =
                "5 3 4" + System.lineSeparator() +
                        "11011"
        val output =
                "8"

        assertIO(input, output);
    }

    @Test
    fun 入力例_4() {
        val input =
                "6 4 6" + System.lineSeparator() +
                        "011101"
        val output =
                "14"

        assertIO(input, output);
    }

    private fun assertIO(input: String, output: String) {
        val sysIn = ByteArrayInputStream(input.toByteArray())
        System.setIn(sysIn)

        val sysOut = ByteArrayOutputStream()
        System.setOut(PrintStream(sysOut))

        bootcamp()

        assertEquals(sysOut.toString(), output + System.lineSeparator())
    }
}


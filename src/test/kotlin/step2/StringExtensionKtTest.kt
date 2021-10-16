package step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringExtensionKtTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `사칙연산 기호일 때 그대로 반환`(input: String) {
        val result = input.toArithmeticSymbolOrNull()

        assertEquals(input, result)
    }

    @ParameterizedTest
    @ValueSource(strings = [".", "ㅇ", "$", "1"])
    fun `사칙연산 기호가 아닐 때 null 반환`(input: String) {
        val result = input.toArithmeticSymbolOrNull()

        assertNull(result)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 과 빈값일 때 null 반환`(input: String?) {
        val result = input.toArithmeticSymbolOrNull()

        assertNull(result)
    }
}

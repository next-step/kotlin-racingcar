package step2

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringExtKtTest {

    @ValueSource(strings = ["(", "*", "!", "@", "+"])
    @ParameterizedTest
    fun `숫자 이외에 값은 에러를 출력한다`(notNumber: String) {
        assertThrows<IllegalArgumentException> { notNumber.toLongOnlyNumber() }
    }
}

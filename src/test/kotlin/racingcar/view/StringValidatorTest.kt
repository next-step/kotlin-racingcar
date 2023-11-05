package racingcar.view

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class StringValidatorTest {
    @Test
    fun `입력값이 없으면 예외를 발생시킨다`() {
        assertThrows(IllegalArgumentException::class.java) {
            "".validateInputNumber()
        }
    }

    @Test
    fun `숫자가 아니면 예외를 발생시킨다`() {
        assertThrows(IllegalArgumentException::class.java) {
            "a".validateInputNumber()
        }
    }

    @Test
    fun `입력값이 숫자이면 예외를 발생시키지 않는다`() {
        "1".validateInputNumber()
    }

    @Test
    fun `입력값이 두자리 이상의 숫자여도 예외를 발생시키지 않는다`() {
        "123".validateInputNumber()
    }
}

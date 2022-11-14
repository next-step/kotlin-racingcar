package racingcar.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RegisterResultTest {

    @Test
    @DisplayName("자동차 이름의 배열이 빈 배열일 경우 IllegalArgumentException 오류")
    fun `Error if car name array is an empty array`() {
        assertThrows<IllegalArgumentException> {
            RegisterResult(listOf(), 5)
        }
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 IllegalArgumentException 오류")
    fun `Error when car name is 5 length`() {
        assertThrows<IllegalArgumentException> {
            RegisterResult(listOf("asdfghjkll"), 5)
        }
    }

    @Test
    @DisplayName("시도할 횟수의 입력 값이 0일 경우 IllegalArgumentException 오류")
    fun `Error when number is 0`() {
        assertThrows<IllegalArgumentException> {
            RegisterResult(listOf("pobi", "crong", "honux"), 0)
        }
    }
}

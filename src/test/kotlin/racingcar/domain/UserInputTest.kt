package racingcar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserInputTest {
    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "-3"])
    fun `자동차 대수로 음수를 입력한 경우`(input: String) {
        // given
        val negative = input.toInt()

        assertThrows<IllegalArgumentException> { // then
            UserInput( // when
                numOfCars = negative,
                numOfAttempts = POSTIVE
            )
        }.also {
            Assertions.assertEquals("자동차 대수는 0 이상의 숫자여야 합니다. (입력된 값: $negative)", it.message)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "-3"])
    fun `게임 시도 횟수로 음수를 입력한 경우`(input: String) {
        // given
        val negative = input.toInt()

        assertThrows<IllegalArgumentException> { // then
            UserInput( // when
                numOfCars = POSTIVE,
                numOfAttempts = negative
            )
        }.also {
            Assertions.assertEquals("게임 횟수는 0 이상의 숫자여야 합니다. (입력된 값: $negative)", it.message)
        }
    }

    companion object {
        private const val POSTIVE = 1
    }
}
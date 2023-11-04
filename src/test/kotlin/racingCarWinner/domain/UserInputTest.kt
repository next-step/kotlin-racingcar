package racingCarWinner.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingCarWinner.domain.UserInput

class UserInputTest {
    @ParameterizedTest
    @ValueSource(strings = ["", ",", " , ", "\n", "\t"])
    fun `식별 가능한 자동차 이름이 0개인 경우 IllegalArgumentException을 발생시킨다`(input: String) {
        assertThrows<IllegalArgumentException> {
            UserInput.of(
                carNames = input,
                numOfAttempts = "1"
            )
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["자동차자동차", "자동차 자동차 자동차"])
    fun `자동차 이름이 5자를 초과하는 경우 IllegalArgumentException을 발생시킨다`(input: String) {
        assertThrows<IllegalArgumentException> {
            UserInput.of(
                carNames = input,
                numOfAttempts = "1"
            )
        }
    }
}
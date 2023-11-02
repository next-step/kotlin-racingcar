package racingCarWinner.domain

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserInputTest {
    @ParameterizedTest
    @ValueSource(strings = ["", ",", " , ", "\n", "\t"])
    fun `식별 가능한 자동차 이름이 0개인 경우 IllegalArgumentException을 발생시킨다`(input: String) {
        TODO()
    }

    @ParameterizedTest
    @ValueSource(strings = ["자동차자동차", "자동차자동차자동차"])
    fun `자동차 이름이 5자를 초과하는 경우 IllegalArgumentException을 발생시킨다`(input: String) {
        TODO()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "\n", "\t"])
    fun `콤마(,)를 기준으로 자동차 이름을 구분하고 List에 담아 반환한다`(input: String) {
        TODO()
    }
}
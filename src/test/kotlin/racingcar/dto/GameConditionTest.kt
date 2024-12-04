package racingcar.dto

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameConditionTest {
    @ParameterizedTest
    @ValueSource(strings = ["-1", "-100", "-55", "-555"])
    fun `게임 라운드 수를 양수가 아닌 수를 입력하면 예외가 발생한다`(negativeNumber: String) {
        shouldThrow<IllegalArgumentException> {
            GameCondition("a,b", negativeNumber)
        }
    }
}

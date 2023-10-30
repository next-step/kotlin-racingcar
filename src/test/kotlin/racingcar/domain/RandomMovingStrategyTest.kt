package racingcar.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RandomMovingStrategyTest {

    @Test
    @DisplayName("무작위로 범위 내 숫자를 반환한다")
    fun generateRandomNumber() {
        // given
        val strategy = RandomMovingStrategy()

        // when
        val randomNumber = strategy.generateRandomNumber()

        // then
        assert(randomNumber in 0..RandomMovingStrategy.MAX_CONDITION)
    }
}
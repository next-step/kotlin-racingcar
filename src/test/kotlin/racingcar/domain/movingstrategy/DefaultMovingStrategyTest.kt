package racingcar.domain.movingstrategy

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DefaultMovingStrategyTest {

    @ParameterizedTest
    @CsvSource(value = ["3, false", "4, true", "5, true"])
    fun `기본 전략은 4 이상일 시 true를 반환한다`(value: Int, expected: Boolean) {
        val defaultMovingStrategy = DefaultMovingStrategy { value }

        defaultMovingStrategy.isMovable() shouldBe expected
    }

}

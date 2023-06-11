package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step3.domain.strategy.AlwaysMoveCondition
import step3.domain.strategy.NeverMoveCondition
import step3.domain.strategy.RandomMoveCondition

internal class CarTest {
    @ParameterizedTest
    @CsvSource(
        "4, 4, 10, 1",
        "4, 0, 1, 0",
        "4, 0, 4, 0",
    )
    internal fun `RadomMoveCondition을 가진 자동차는 threshold가 4일때 무작위 값이 4 이상이면 전진한다`(
        threshold: Int,
        boundFrom: Int,
        boundUntil: Int,
        expectedPosition: Int
    ) {
        val sut = Car(RandomMoveCondition(threshold = threshold, boundFrom = boundFrom, boundUntil = boundUntil))
        sut.move()
        assertThat(sut.position).isEqualTo(expectedPosition)
    }

    @Test
    internal fun `AlwaysMoveCondition을 가진 자동차는 항상 전진한다`() {
        val sut = Car(AlwaysMoveCondition())
        sut.move()
        assertThat(sut.position).isEqualTo(1)
    }

    @Test
    internal fun `NeverMoveCondition을 가진 자동차는 전진하지 않는다`() {
        val sut = Car(NeverMoveCondition())
        sut.move()
        assertThat(sut.position).isEqualTo(0)
    }
}

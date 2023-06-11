package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.strategy.AlwaysMoveCondition
import step3.domain.strategy.NeverMoveCondition

internal class RacingCarsTest {
    @Test
    internal fun `레이싱 테스트`() {
        // given : 항상 전진하는 1개의 자동차와 항상 전진하지 않는 1개의 자동차 준비
        val cars = listOf(
            Car(carMovingStrategy = AlwaysMoveCondition()),
            Car(carMovingStrategy = NeverMoveCondition())
        )
        val racingCars = RacingCars(cars)

        // when : 2번의 전진 시도를 가지고 레이싱 수행
        val racingRecord = racingCars.race(2)

        // then : 항상 전진하는 자동차는 2번 전진, 항상 전진하지 않는 자동차는 0번 전진
        val expectedRacingRecord = listOf(listOf(1, 0), listOf(2, 0))
        assertThat(racingRecord.record).containsExactlyElementsOf(expectedRacingRecord)
    }
}

package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.mock.FakeForwardCondition

class CarsTest {

    @Test
    fun `n 개 car를 생성한다`() {
        // given
        val carNames = listOf("car1", "car2")

        // when
        val cars = Cars.of(carNames, RandomNumberForwardCondition())

        // then
        assertThat(cars.size()).isEqualTo(carNames.size)
    }

    @Test
    fun `race 를 호출하는 경우 전진조건에 따라 distance 가 증가한다`() {
        // given
        val carNames = listOf("car1", "car2")
        val cars = Cars.of(carNames, FakeForwardCondition(true))

        // when
        val racingPhaseRecords = cars.race()

        // then
        assertAll({
            assertThat(racingPhaseRecords.records.size).isEqualTo(carNames.size)
            racingPhaseRecords.records.forEach { racingPhaseRecord ->
                assertThat(racingPhaseRecord.distance).isEqualTo(2)
            }
        })
    }
}

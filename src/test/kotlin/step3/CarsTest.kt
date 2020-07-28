package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `넣은 자동차 개수만큼 자동차 거리 List개수를 반환하는지 확인`() {
        // given
        val car = Car("A", CarMover())
        val cars = Cars(listOf(car))

        // then
        assertThat(cars.getCurrentRacingRecord().value).hasSize(1)
    }

    @Test
    fun `현재 자동차들의 이름과 거리가 담긴 기록을 제대로 만드는지 확인`() {
        // given
        val car1 = Car("A", CarMover())
        val car2 = Car("B", CarMover())
        val cars = Cars(listOf(car1, car2))

        val expectedRacingRecord = RacingRecord(mapOf("A" to 0, "B" to 0))

        // then
        assertThat(cars.getCurrentRacingRecord())
            .isEqualTo(expectedRacingRecord)
    }
}

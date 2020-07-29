package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `넣은 자동차 개수만큼 자동차 거리 List개수를 반환하는지 확인`() {
        // given
        val car = Car("A", CarMover())
        val cars = Cars(listOf(car, car, car))

        // then
        assertThat(cars.getCurrentRacingRecords()).hasSize(3)
    }

    @Test
    fun `현재 자동차들의 이름과 거리가 담긴 기록을 제대로 만드는지 확인`() {
        // given
        val car = Car("A", CarMover())
        val cars = Cars(listOf(car, car))

        val racingRecord = RacingRecord("A", 0)
        val expectedRacingRecords = listOf(racingRecord, racingRecord)

        // then
        assertThat(cars.getCurrentRacingRecords())
            .isEqualTo(expectedRacingRecords)
    }
}

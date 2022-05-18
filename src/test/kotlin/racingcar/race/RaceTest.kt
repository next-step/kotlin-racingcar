package racingcar.race

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.count.CarCount
import racingcar.count.MoveCount

class RaceTest {
    @Test
    fun `주어진 carCount 에 따라 carList 사이즈가 결정된다`() {
        for (int in 1..10) {
            val race = Race(CarCount(int), MoveCount(5))
            Assertions.assertThat(race.cars.size).isEqualTo(int)
        }
    }

    @Test
    fun `주어진 MoveCount 에 따라 railSize 가 결정된다`() {
        for (int in 1..10) {
            val race = Race(CarCount(5), MoveCount(int))
            Assertions.assertThat(race.railSize).isEqualTo(int)
        }
    }
}

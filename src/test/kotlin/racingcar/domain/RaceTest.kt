package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `우승자 찾기`() {
        val race = Race(1)
        val aCar = Car(0, "a")
        val bCar = Car(1, "b")
        val cCar = Car(1, "c")
        val cars = listOf(aCar, bCar, cCar)
        val winners = race.findWinnersName(cars)
        assertThat(winners).isEqualTo(listOf(bCar.name, cCar.name))
    }

    @Test
    fun `MovigRule에서 항상 참이도록 전력 변경했을 경우 차가 움직이는지 확인`() {
        val race = Race(1)
        val aCar = Car(0, "a")
        val cars = listOf(aCar)
        race.run(cars)
        assertThat(cars.map { it.route }).isEqualTo(listOf(1))
    }
}

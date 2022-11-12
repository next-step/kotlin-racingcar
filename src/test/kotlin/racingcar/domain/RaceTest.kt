package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest{

    @Test
    fun `우승자 찾기`(){
        val race = Race(1)
        val aCar = Car(0, "a")
        val bCar = Car(1, "b")
        val cCar = Car(1, "c")
        val cars = listOf(aCar, bCar, cCar)
        val winners = race.findWinner(cars)
        assertThat(winners).isEqualTo(listOf(bCar, cCar))
    }
}

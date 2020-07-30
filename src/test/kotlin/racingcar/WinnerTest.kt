package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {
    @Test
    fun first_car_add_winner_list() {
        val car1 = Car("1")
        val carList = listOf(car1)

        val winner = Winner(carList)

        assertThat(winner.winnerList[0]).isEqualTo(car1)
    }

    @Test
    fun change_winner_list() {
        val car1 = Car("1")
        val car2 = Car("2")
        car1.goStop(3)
        car2.goStop(4)
        val carList = listOf(car1, car2)

        val winner = Winner(carList)

        assertThat(winner.winnerList[0]).isEqualTo(car2)
    }

    @Test
    fun stay_winner_list() {
        val car1 = Car("1")
        val car2 = Car("2")
        car1.goStop(4)
        car2.goStop(3)
        val carList = listOf(car1, car2)

        val winner = Winner(carList)

        assertThat(winner.winnerList[0]).isEqualTo(car1)
    }

    @Test
    fun same_winner_list() {
        val car1 = Car("1")
        val car2 = Car("2")
        car1.goStop(4)
        car2.goStop(4)
        val carList = listOf(car1, car2)

        val winner = Winner(carList)

        assertThat(winner.winnerList).isEqualTo(carList)
    }
}

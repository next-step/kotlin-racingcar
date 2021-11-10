package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTest {

    @Test
    fun 우승자_이름() {
        val cars = listOf(
            Car(CarName("자동차1"), MoveDistance(10)),
            Car(CarName("자동차2"), MoveDistance(100)),
            Car(CarName("자동차3"), MoveDistance(1000)),
            Car(CarName("자동차4"), MoveDistance(10000))
        )

        assertThat(Winners.winnerNames(cars)).isEqualTo("자동차4")
    }

    @Test
    fun 우승자_중복() {
        val cars = listOf(
            Car(CarName("자동차1"), MoveDistance(10)),
            Car(CarName("자동차2"), MoveDistance(100)),
            Car(CarName("자동차3"), MoveDistance(10000)),
            Car(CarName("자동차4"), MoveDistance(10000))
        )

        assertThat(Winners.winnerNames(cars)).isEqualTo("자동차3, 자동차4")
    }
}

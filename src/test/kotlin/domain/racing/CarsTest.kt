package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `4이상이면 차들이 움직인다`(moveNumber: Int) {
        val cars = Cars.of(listOf(Name("pobi"), Name("jason"), Name("marco")))

        cars.move { moveNumber }

        val result = cars.toResult()

        result.values.forEach { assertThat(it).isEqualTo("-") }
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `4미만이면 차들이 안움직인다`(moveNumber: Int) {
        val cars = Cars.of(listOf(Name("pobi"), Name("jason"), Name("marco")))

        cars.move { moveNumber }

        val result = cars.toResult()

        result.values.forEach { assertThat(it).isEqualTo("") }
    }

    @Test
    fun `가장 많이 움직인 차로 우승자를 뽑는다`() {
        val car1 = Car(Name("pobi"), Position(1))
        val car2 = Car(Name("jason"), Position(2))
        val car3 = Car(Name("marco"), Position(3))
        val cars = Cars(listOf(car1, car2, car3))

        val winners = cars.toWinners()

        assertAll(
            { assertThat(winners.winners).hasSize(1) },
            { assertThat(winners.winners.first().getName()).isEqualTo("marco") }
        )
    }
}

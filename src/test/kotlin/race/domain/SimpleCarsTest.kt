package race.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SimpleCarsTest {
    @Test
    fun `가장 멀리 이동한 자동차들이 공동우승한다`() {
        val carNames = arrayOf("t1", "t2", "t3")
        val cars = SimpleCars(listOf(*carNames))

        Assertions.assertThat(cars.findWinners().map { it.name }).contains(*carNames)

        cars.carList.first().move(SimpleCar.MOVE_THRESHOLD)
        Assertions.assertThat(cars.findWinners().size).isEqualTo(1)
        Assertions.assertThat(cars.findWinners().first().name).isEqualTo(carNames.first())

        cars.carList.last().move(SimpleCar.MOVE_THRESHOLD)
        Assertions.assertThat(cars.findWinners().size).isEqualTo(2)
        Assertions.assertThat(
            cars.findWinners().joinToString(", ") { it.name }
        ).isEqualTo("${carNames.first()}, ${carNames.last()}")
    }
}

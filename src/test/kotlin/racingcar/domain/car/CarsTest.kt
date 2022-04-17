package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    internal fun `자동차 이름들로 Cars 객체를 생성할 수 있다`() {
        val rawNames = listOf("가", "나", "다")
        val cars = Cars(CarNames(rawNames))
        assertThat(cars).hasSameSizeAs(rawNames)
    }

    @Test
    internal fun `자동차들은 경주를 할 수 있다`() {
        val cars = Cars(
            cars = listOf(
                Car(name = "가", accelerator = { CarAction.MOVE })
            )
        )
        assertThat(cars).allSatisfy {
            assertThat(it.movedDistance).isEqualTo(0)
        }
        val racedCars = cars.race()
        assertThat(racedCars).allSatisfy {
            assertThat(it.movedDistance).isEqualTo(1)
        }
    }
}

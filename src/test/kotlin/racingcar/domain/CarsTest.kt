package racingcar.domain

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
                Car(name = "가", accelerator = MoveCarAccelerator)
            )
        )
        assertThat(cars).allSatisfy {
            assertThat(it.movedDistance()).isEqualTo(0)
        }
        cars.race()
        assertThat(cars).allSatisfy {
            assertThat(it.movedDistance()).isEqualTo(1)
        }
    }

    @Test
    internal fun `가장 멀리 간 자동차가 우승자고 우승자는 한 명 이상일 수 있다`() {
        val cars = Cars(
            cars = listOf(
                Car(name = "가", accelerator = MoveCarAccelerator),
                Car(name = "나", accelerator = MoveCarAccelerator),
                Car(name = "다", accelerator = StopCarAccelerator),
            )
        )
        cars.race()
        assertThat(cars.winners())
            .containsExactly(
                Car(name = "가", accelerator = MoveCarAccelerator),
                Car(name = "나", accelerator = MoveCarAccelerator)
            )
    }
}
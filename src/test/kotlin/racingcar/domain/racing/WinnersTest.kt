package racingcar.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.car.*
import racingcar.domain.car.Ignore

internal class WinnersTest {

    @Test
    internal fun `가장 멀리 간 자동차가 우승자다`() {
        val cars = Cars(
            listOf(
                Car(name = "가", accelerator = Ignore(), position = CarPosition(10)),
                Car(name = "나", accelerator = Ignore(), position = CarPosition(0)),
            )
        )
        assertThat(Winners(CarsHistory(listOf(cars))).find()).allSatisfy {
            assertThat(it.name).isEqualTo("가")
        }
    }

    @Test
    internal fun `우승자는 한 명 이상일 수 있다`() {
        val cars = Cars(
            listOf(
                Car(name = "가", accelerator = Ignore(), position = CarPosition(10)),
                Car(name = "나", accelerator = Ignore(), position = CarPosition(10)),
                Car(name = "다", accelerator = Ignore(), position = CarPosition(0)),
            )
        )
        assertThat(Winners(CarsHistory(listOf(cars))).find()).hasSize(2)
    }
}

package racing.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.domain.Car
import racing.infra.RandomCarMovingStepper

internal class CarServiceTest {

    @Test
    fun `주어진 라운드만큼 자동차를 진행시킨다`() {
        val round = 3
        val cars: List<Car> = List(3) { Car(0) }

        val carService = CarService(RandomCarMovingStepper())

        val moveCars = carService.moveCars(cars, round)

        assertAll("CarServiceTest",
            { assertThat(moveCars.size).isEqualTo(3) },
            { assertThat(moveCars[0].positions.size).isEqualTo(3) },
            { assertThat(moveCars[1].positions.size).isEqualTo(3) },
            { assertThat(moveCars[2].positions.size).isEqualTo(3) },
        )
    }
}

package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.ResultStatistics

class RacingGameTest {

    @Test
    fun `실행결과 출력`() {
        val cars: Cars = CarFactory.create(1)
        for (car in cars.list()) {
            car.move(4)
        }
        assertThat(ResultStatistics(cars).toResult()).isEqualTo("-\n")
    }
}

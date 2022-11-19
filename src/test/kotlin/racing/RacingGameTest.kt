package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.ResultStatistics

class RacingGameTest {

    @Test
    fun `실행결과 출력`() {
        val cars: Cars = CarFactory.create(2)
        for (car in cars) {
            car.move(4)
        }
        assertThat(ResultStatistics(cars).toResult()).isEqualTo("-${System.lineSeparator()}-")
    }
}

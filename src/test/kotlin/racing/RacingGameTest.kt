package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.ResultStatistics

class RacingGameTest {

    @Test
    fun `실행결과 출력`() {
        val names = "lee,kkoks"
        val cars: Cars = CarFactory.create(names)
        for (car in cars) {
            car.move(4)
        }

        val result = """
            lee: -
            kkoks: -
        """.trimIndent()
        assertThat(ResultStatistics(cars).toResult()).isEqualTo(result)
    }
}

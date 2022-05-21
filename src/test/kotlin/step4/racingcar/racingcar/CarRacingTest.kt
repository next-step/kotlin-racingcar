package step4.racingcar.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest {

    @Test
    internal fun `차량 이동 테스트`() {
        val racers = listOf("molly")
        val racing = CarRacing(racers, 10)
        racing.execute(MockNumberGenerator)

        assertThat(racing.gameResult.cars.first().getMovementCount()).isEqualTo(10)
    }
}

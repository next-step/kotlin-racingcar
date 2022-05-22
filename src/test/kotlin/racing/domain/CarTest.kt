package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차가 움직인 만큼의 수를 리턴해줘야 한다`() {
        val car = Car("자동차")
        car.move()

        assertThat(car.getMoved()).isEqualTo(1)
    }
}
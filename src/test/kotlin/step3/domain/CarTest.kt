package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `이동거리가 증가했는지 테스트 한다`() {
        val car = Car()

        val distance = car.distance
        car.distanceIncrease()
        assertThat(distance + 1).isEqualTo(car.distance)
    }
}

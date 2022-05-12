package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차가 앞으로 전진한다`() {
        val car = Car(1)

        val movePosition = car.movePosition()

        assertThat(movePosition.position).isEqualTo(2)
    }

    @Test
    fun `자동차는 불변객체를 리턴한다`() {
        val car = Car(1)

        val movePosition = car.movePosition()

        assertThat(car).isNotEqualTo(movePosition)
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차는 번호와 위치를 가지고 있다`() {
        val givenNumber = 1
        val givenPosition = 2
        val car = Car(givenNumber, givenPosition)

        assertAll(
            { assertThat(car.carNumber).isEqualTo(givenNumber) },
            { assertThat(car.position).isEqualTo(givenPosition) }
        )
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car(1)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차의 위치가 0보다 작으면 예외를 던진다`() {
        assertThatCode { Car(1, -1) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

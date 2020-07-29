package step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step3.domain.Car
import step3.domain.CarMover
import step3.domain.Mover

class CarTest {

    @CsvSource("true,1", "false,0")
    @ParameterizedTest
    fun `race호출 시 전진 조건에 따라 거리가 변하는지 확인`(canMove: Boolean, expectedDistance: Int) {
        // given
        val car = Car(
            "car",
            object : Mover {
                override fun canMove(): Boolean {
                    return canMove
                }
            }
        )

        // when
        car.race()

        // then
        assertThat(car.distance).isEqualTo(expectedDistance)
    }

    @Test
    fun `자동차 이름 5자 초과시 Exception`() {
        // given
        val name = "가나다라마바"

        // then
        assertThatThrownBy { Car(name, CarMover()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다. \"${name}\"의 길이 : ${name.length}")
    }
}

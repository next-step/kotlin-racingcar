package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {

    @CsvSource("true,1", "false,0")
    @ParameterizedTest
    fun `race호출 시 전진 조건에 따라 거리가 변하는지 확인`(canMove: Boolean, expectedDistance: Int) {
        // given
        val car = Car(object : Mover {
            override fun canMove(): Boolean {
                return canMove
            }
        })

        // when
        car.race()

        // then
        assertThat(car.distance).isEqualTo(expectedDistance)
    }
}

package car.domain

import car.domain.Car.Companion.INIT_POSITION
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤이 4 미만이고 움직일 경우 포지션은 0이여야 한다`(rand: Int) {
        // given
        val car: Car = Car("오길환", createEnergyProvider(rand))
        // when
        car.move()
        // then
        assertThat(car.currentPosition)
            .isEqualTo(INIT_POSITION)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤이 4 이상이고 움직일 경우 포지션은 1이여야 한다`(rand: Int) {
        // given
        val car: Car = Car("오길환", createEnergyProvider(rand))
        // when
        car.move()
        // then
        assertThat(car.currentPosition)
            .isEqualTo(INIT_POSITION + 1)
    }

    @Test
    fun `이름이 5글자 초과이면 Exception이 발생해야 한다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Car("5글자가넘는이룸", createEnergyProvider(nextInt = 9)) }
    }

    private fun createEnergyProvider(nextInt: Int): EnergyProvider {
        return object : EnergyProvider {
            override val energy: Int
                get() = nextInt
        }
    }
}

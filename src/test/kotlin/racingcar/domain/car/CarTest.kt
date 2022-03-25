package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarTest {

    @Test
    internal fun `각 자동차에 이름을 부여할 수 있다`() {
        val car = Car("김수현")
        assertThat(car.name).isEqualTo("김수현")
    }

    @Test
    internal fun `자동차의 이름은 5글자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Car("가나다라마바") }
    }

    @ParameterizedTest
    @MethodSource("provideCarAcceleratorPosition")
    internal fun `자동차는 사용하는 악셀에 따라 움직인 거리가 달라진다`(accelerator: CarAccelerator, expectedPosition: Int) {
        val car = Car(name = "test", accelerator = accelerator)
        car.drive()
        assertThat(car.movedDistance()).isEqualTo(expectedPosition)
    }

    companion object {
        @JvmStatic
        private fun provideCarAcceleratorPosition(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(StopCarAccelerator, 0),
                Arguments.of(MoveCarAccelerator, 1),
            )
        }
    }
}

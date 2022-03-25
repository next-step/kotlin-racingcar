package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.car.CarAction
import racingcar.domain.car.CarPosition
import java.util.stream.Stream

internal class CarPositionTest {

    @Test
    internal fun `CarPosition에 position 값을 부여할 수 있다`() {
        val carPosition = CarPosition(123)
        assertThat(carPosition.get()).isEqualTo(123)
    }

    @ParameterizedTest
    @MethodSource("provideCarActionPosition")
    internal fun `CarPosition에 action을 적용하여 position에 영향을 줄 수 있다`(carAction: CarAction, expectedPosition: Int) {
        val carPosition = CarPosition(0)
        carPosition.applyAction(carAction)
        assertThat(carPosition.get()).isEqualTo(expectedPosition)
    }

    companion object {
        @JvmStatic
        private fun provideCarActionPosition(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(CarAction.STOP, 0),
                Arguments.of(CarAction.MOVE, 1),
            )
        }
    }
}

package study.racingcar.step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarTest {

    @ParameterizedTest
    @MethodSource("argumentsByAbleNumberAndRunValueResult")
    fun `차 동작 확인 Test`(ableNumber: Int, runValue: Int, expectationResult: Int) {
        val car = Car(ableNumber, "name")
        car.run(runValue)
        assertThat(car.getPosition()).isEqualTo(expectationResult)
    }

    companion object {
        @JvmStatic private fun argumentsByAbleNumberAndRunValueResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, 4, 1),
                Arguments.of(5, 4, 0)
            )
        }
    }
}

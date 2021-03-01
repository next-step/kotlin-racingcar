package study.racingcar.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarTest {

    @ParameterizedTest
    @MethodSource("argumentsByAbleNumberAndRunValueResult")
    fun `차 동작 확인 Test`(ableNumber: Int, runValue: Int, expectationResult: String) {
        val car = Car(ableNumber, 0)
        car.run(runValue)
        assertThat(car.render()).isEqualTo(expectationResult)
    }

    companion object {
        @JvmStatic private fun argumentsByAbleNumberAndRunValueResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, 4, "-"),
                Arguments.of(5, 4, "")
            )
        }
    }
}

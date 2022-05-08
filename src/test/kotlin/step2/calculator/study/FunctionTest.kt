package step2.calculator.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.function.BiFunction

class FunctionTest {

    @Test
    fun `코틀린 함수 학습 테스트 - 곱셈식 작성`() {
        val multi: (Double, Double) -> Double = { x: Double, y: Double -> x * y }
        val multiByBiFunction: BiFunction<Double, Double, Double> = BiFunction { x, y -> x * y }

        assertThat(multi(5.0, 10.0))
            .isEqualTo(
                multiByBiFunction.apply(5.0, 10.0)
            )
    }

    @Test
    fun `코틀린 함수 학습 테스트 - 나눗셈식 작성`() {
        val divide = { x: Double, y: Double -> x / y }
        val divideFunctionByJava = BiFunction { x: Double, y: Double -> x / y }

        assertThat(divide(5.0, 10.0))
            .isEqualTo(
                divideFunctionByJava.apply(5.0, 10.0)
            )
    }
}

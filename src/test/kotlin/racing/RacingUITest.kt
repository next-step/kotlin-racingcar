package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import racing.domain.Car
import racing.domain.RacingCars
import racing.domain.Winners
import racing.view.RacingUI
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.stream.Stream

class RacingUITest {

    private val output = ByteArrayOutputStream()

    @BeforeEach
    private fun setup() {
        output.reset()
        System.setOut(PrintStream(output))
    }

    @ParameterizedTest
    @ArgumentsSource(DrawCarsArgumentsProvider::class)
        /* ex) 이름 표시 + ":" + 이동 한칸 "-" 로 표시 / 시작 지점 "-" 로 표시
        David : --
        Alora : -
        User : ---

         */
    fun `차량의 현재 상태를 출력한다`(cars: RacingCars, expect: String) {
        RacingUI.drawCars(cars)

        Assertions.assertThat(output.toString()).isEqualTo(expect)
    }

    @Test
    fun `우승 차량 정보를 출력한다`() {
        val cars = Winners(listOf(Car("Andy"), Car("Bruce")))
        val expect = "Andy, Bruce가 최종 우승했습니다."

        RacingUI.drawWinners(cars)

        Assertions.assertThat(output.toString().trimIndent()).isEqualTo(expect)
    }

    class DrawCarsArgumentsProvider : ArgumentsProvider {
        private val testData = listOf(
            RacingCars(listOf(Car("Andy", startPosition = 4), Car("Bruce", startPosition = 2))) to
                """
                |Andy : -----
                |Bruce : ---
                |
                |
            """.trimMargin(),
            RacingCars(listOf(Car("Andy", startPosition = 0))) to
                """
                |Andy : -
                |
                |
            """.trimMargin()
        )

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            val testArguments = testData.map { (cars, expect) ->
                Arguments.of(cars, expect)
            }

            return Stream.of(*testArguments.toTypedArray())
        }
    }
}

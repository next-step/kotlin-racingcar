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
import racing.ui.RacingUI
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.stream.Stream
import kotlin.random.Random

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
    fun `차량의 현재 상태를 출력한다`(cars: List<Car>, expect: String) {
        RacingUI.drawCars(cars)

        Assertions.assertThat(output.toString()).isEqualTo(expect)
    }

    @Test
    fun `우승 차량 정보를 출력한다`() {
        val cars = listOf(Car("Andy"), Car("Bruce"))
        val expect = "Andy, Bruce가 최종 우승했습니다."

        RacingUI.drawWinners(cars)

        Assertions.assertThat(output.toString().trimIndent()).isEqualTo(expect)
    }

    class DrawCarsArgumentsProvider : ArgumentsProvider {
        private val names = listOf("Andy", "Bruce", "Clara", "David", "Echo", "Flora")
        private val random = Random(123456789)
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            val stream = Stream.builder<Arguments>()

            repeat(3) {
                val cars = generateCars()
                stream.add(Arguments.of(cars, generateExcept(cars)))
            }
            return stream.build()
        }

        private fun generateCars(): List<Car> {
            val carNames = names.shuffled(random).take(random.nextInt(8))

            return carNames.map { Car(name = it, startPosition = random.nextInt(10)) }
        }

        private fun generateExcept(cars: List<Car>): String {
            return cars.joinToString(separator = "\n", postfix = "\n\n") { car ->
                "${car.name} : ${"-".repeat(car.position + 1)}"
            }
        }
    }
}

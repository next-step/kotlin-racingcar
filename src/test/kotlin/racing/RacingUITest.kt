package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
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
    @ArgumentsSource(CarStateArgumentsProvider::class)
        /* ex) 이동 한칸 "-" 로 표시 / 시작 지점 "-" 로 표시
        --
        -
        ---

         */
    fun `차량의 현재 상태를 출력한다`(cars: List<Car>, expect: String) {
        RacingUI().drawCars(cars)

        Assertions.assertThat(output.toString()).isEqualTo(expect)
    }

    class CarStateArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(generateCars(listOf(1, 2, 3)), "--\n---\n----\n\n"),
                Arguments.of(generateCars(listOf(0, 0)), "-\n-\n\n"),
                Arguments.of(generateCars(listOf(0, 5, 3, 2, 0)), "-\n------\n----\n---\n-\n\n")
            )
        }

        private fun generateCars(moveList: List<Int>): List<Car> {
            return moveList.map { Car(name = "", startPosition = it) }
        }
    }
}

package racing.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racing.model.Car
import racing.model.Round
import java.util.stream.Stream

internal class CarRacingTest {

    @ParameterizedTest
    @MethodSource("generateData")
    fun `start method create each round result`(carNames: List<String>, tries: Int) {
        val carRacing = CarRacing(carNames, tries)
        val raceResult = carRacing.start()

        val expectedKeys = Array(tries) { it }
        val expectedValue = Round( carNames.map { Car(name = it) } )
        assertThat(raceResult)
            .containsKeys(*expectedKeys)
            .containsEntry(0, expectedValue)
    }

    companion object {
        @JvmStatic
        private fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("name1", "name2", "name3"), 3),
                Arguments.of(listOf("name1", "name2", "name3"), 20),
                Arguments.of(listOf("name1", "name2", "name3"), 15),
                Arguments.of(listOf("name1", "name2", "name3"), 1),
            )
        }
    }
}

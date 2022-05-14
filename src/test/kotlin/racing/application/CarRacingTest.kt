package racing.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.model.Car

internal class CarRacingTest {

    @Test
    fun `first round do initialization test`() {
        val carNames = listOf("name1", "name2", "name3")
        val carRacing = CarRacing(carNames, 3)
        assertThat(carRacing.eachRoundMap)
            .isEmpty()

        carRacing.round(1)
        val expected = List(3) { Car(carNames[it]) }

        assertThat(carRacing.eachRoundMap[1])
            .isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "[\"name1\", \"name2\", \"name3\"], 3",
        "[\"name1\", \"name2\", \"name3\"], 20",
        "[\"name1\", \"name2\", \"name3\"], 15",
        "[\"name1\", \"name2\", \"name3\"], 1"
    )
    fun `start method create each round result`(carNames: List<String>, tries: Int) {
        val carRacing = CarRacing(carNames, tries)
        carRacing.start()

        val expectedKeys = Array(tries) { it }
        val expectedValue = carNames.map { Car(name = it) }
        assertThat(carRacing.eachRoundMap)
            .containsKeys(*expectedKeys)
            .containsEntry(0, expectedValue)
    }
}

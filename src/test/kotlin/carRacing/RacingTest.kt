package carRacing

import carRacing.Domain.Car
import carRacing.Domain.Racing
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingTest {

    @ParameterizedTest
    @CsvSource("1", "2", "3")
    fun `자동차 경주 게임의 carCount 만큼의 Car List 를 반환`(carCount: Int) {
        val racing: Racing = Racing()

        val carList: List<Car> = racing.process(carCount)

        assertThat(carList.size).isEqualTo(carCount)
    }
}
package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racing.model.Car
import racing.model.Driver
import java.util.stream.Stream

internal class RacingRecordBoardTest {

    lateinit var racingRecordBoard: RacingRecordBoard

    @BeforeEach
    fun setUp() {
        racingRecordBoard = RacingRecordBoard()
    }

    @ParameterizedTest
    @MethodSource("provideDrivers")
    fun `자동차 경주 결과 정보를 저장한 경우`(cars: List<Pair<String, Int>>) {
        val result = cars.map { (driver, mileage) ->
            Car(Driver(driver), mileage)
        }
        racingRecordBoard.add(result)
        assertThat(racingRecordBoard.results.first().result).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("provideDriversWithWinner")
    fun `자동차 경주 우승자 확인`(cars: List<Pair<String, Int>>, winnerDriver: String) {
        val result = cars.map { (driver, mileage) ->
            Car(Driver(driver), mileage)
        }
        racingRecordBoard.add(result)
        val winner = Driver(winnerDriver)
        assertThat(racingRecordBoard.winners).isEqualTo(listOf(winner))
    }

    companion object {
        @JvmStatic
        fun provideDrivers(): Stream<List<Pair<String, Int>>> {
            val test = listOf("똘기" to 1, "떵이" to 2, "호치" to 3, "새초미" to 1)
            return Stream.of(test)
        }

        @JvmStatic
        fun provideDriversWithWinner(): Stream<Arguments> {
            val test = listOf("똘기" to 1, "떵이" to 2, "호치" to 3, "새초미" to 1)
            return Stream.of(Arguments.of(test, "호치"))
        }
    }
}

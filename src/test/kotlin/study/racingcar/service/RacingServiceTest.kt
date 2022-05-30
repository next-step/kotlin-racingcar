package study.racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.domain.Car
import study.racingcar.repository.impl.RoundMemoryRepositoryImpl

internal class RacingServiceTest {

    val roundRepository = RoundMemoryRepositoryImpl()

    val sut = RacingService(roundRepository)

    val carNames = listOf("a", "b", "c")

    lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        cars = carNames.map { Car(it) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100])
    fun `race를 할 수 있다`(totalRound: Int) {
        sut.start(totalRound, cars)

        roundRepository.findAll().forEach { round ->
            assertThat(round.cars.map { it.name }).isEqualTo(carNames)
            round.cars.forEach { car ->
                assertThat(car.position).isLessThanOrEqualTo(totalRound)
            }
        }
    }
}

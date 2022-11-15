package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racing.domain.RacingCarsFactory
import racing.domain.RacingCarsFactoryImpl
import racing.model.Driver
import java.util.stream.Stream


internal class RacingGarageTest {

    private lateinit var racingCarsFactory: RacingCarsFactory

    @BeforeEach
    fun setUp() {
        racingCarsFactory = RacingCarsFactoryImpl()
    }

    /**
     * FYI, inline class 아직 ParameterizedTest 미지원
     * https://github.com/junit-team/junit5/issues/2703
     */
    @ParameterizedTest
    @MethodSource("provideDrivers")
    fun `필요한 차량 수 만큼 자동차를 생성한다`(drivers: List<String>) {
        RacingCarGarage(
            racingCarsFactory = racingCarsFactory,
        )
            .apply { setCarsWithDrivers(drivers.map { Driver(it) }) }
            .cars
            .count()
            .let(::assertThat)
            .isEqualTo(drivers.count())
    }

    @ParameterizedTest
    @MethodSource("provideDrivers")
    fun `경주차 차고에 1씩 이동된 자동차를 주차하면 이동된 자동차 정보가 저장된다`(drivers: List<String>) {
        // Given
        val racingCarGarage = RacingCarGarage(
            racingCarsFactory = racingCarsFactory,
        ).apply {
            setCarsWithDrivers(drivers.map { Driver(it) })
        }
        val testCarResult = racingCarGarage.cars
            .map { car -> car.copy(mileage = car.mileage + 1) }
        // When
        racingCarGarage.parkCars(testCarResult)
        // Then
        assertThat(racingCarGarage.cars).isEqualTo(testCarResult)
    }

    companion object {
        @JvmStatic
        fun provideDrivers(): Stream<List<String>> =
            Stream.of(listOf("똘기", "떵이", "호치", "새초미"))
    }
}

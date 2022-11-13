package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racing.model.Driver
import java.util.stream.Stream

internal class RacingCarsFactoryImplTest {

    private lateinit var racingCarsFactory: RacingCarsFactory

    @BeforeEach
    fun setUp() {
        racingCarsFactory = RacingCarsFactoryImpl()
    }

    @ParameterizedTest
    @MethodSource("provideDriveNames")
    fun `1명 이상 드라이버가 자동차가 필요하여 생성해야 되는 경우`(drivers: List<String>) {
        val cars = racingCarsFactory.createCars(drivers.map { Driver(it) })
        assertThat(cars.size).isEqualTo(drivers.size)
    }

    companion object {
        @JvmStatic
        fun provideDriveNames(): Stream<List<String>> =
            Stream.of(listOf("똘기", "떵이", "호치", "새초미"), listOf("드라곤", "요롱이", "마초", "미미"))
    }
}

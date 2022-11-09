package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.RacingCarsFactory
import racing.domain.RacingCarsFactoryImpl
import racing.model.CarCount


internal class RacingCarGarageTest {

    lateinit var racingCarsFactory: RacingCarsFactory

    @BeforeEach
    fun setUp() {
        racingCarsFactory = RacingCarsFactoryImpl()
    }

    /**
     * FYI, inline class 아직 ParameterizedTest 미지원
     * https://github.com/junit-team/junit5/issues/2703
     */
    @ParameterizedTest
    @ValueSource(ints = [3, 10, 2])
    fun `필요한 차량 수 만큼 자동차를 생성한다`(carCount: Int) {
        RacingCarGarage(
            carCount = CarCount(carCount),
            racingCarsFactory = racingCarsFactory,
        )
            .cars
            .count()
            .let(::assertThat)
            .isEqualTo(carCount)
    }

    @Test
    fun `1 lap 돈 차량을 차고에 주차(저장)한다`() {
        val racingCarGarage = RacingCarGarage(
            carCount = CarCount(5),
            racingCarsFactory = racingCarsFactory,
        )
        val testCarResult = racingCarGarage.cars
            .mapIndexed { index, car ->
                if (index % 2 == 0) car.copy(car.mileage + 1) else car.copy()
            }
        racingCarGarage.parkCars(testCarResult)
        assertThat(racingCarGarage.cars).isEqualTo(testCarResult)
    }
}

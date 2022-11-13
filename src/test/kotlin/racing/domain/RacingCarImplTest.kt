package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import racing.model.Car
import racing.model.CarAction

internal class RacingCarImplTest {
    lateinit var racingCar: RacingCar
    lateinit var goOrStopCarAction: GoOrStopCarAction

    @ParameterizedTest
    @EnumSource(value = CarAction::class, names = ["GO"])
    fun `자동차가 움직일 경우`(carAction: CarAction) {
        goOrStopCarAction = FakeGoOrStopCarAction(carAction)
        racingCar = RacingCarImpl(goOrStopCarAction)

        val car = Car()
        val resultCar = racingCar.driveCar(car)
        assertThat(resultCar.mileage).isEqualTo(car.mileage + 1)
    }

    @ParameterizedTest
    @EnumSource(value = CarAction::class, names = ["STOP"])
    fun `자동차가 움직이지 않을 경우`(carAction: CarAction) {
        goOrStopCarAction = FakeGoOrStopCarAction(carAction)
        racingCar = RacingCarImpl(goOrStopCarAction)

        val car = Car()
        val resultCar = racingCar.driveCar(car)
        assertThat(resultCar.mileage).isEqualTo(car.mileage)
    }
}

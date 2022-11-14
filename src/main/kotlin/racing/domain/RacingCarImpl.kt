package racing.domain

import racing.model.Car

class RacingCarImpl(
    private val goOrStopCarAction: GoOrStopCarAction
) : RacingCar {

    override fun driveCar(car: Car): Car =
        goOrStopCarAction.castCarAction()
            .let { car.copy(mileage = car.mileage + it.value) }
}

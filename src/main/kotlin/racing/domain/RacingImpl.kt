package racing.domain

import racing.model.Car

class RacingImpl(
    private val goOrStopCarAction: GoOrStopCarAction
) : Racing {

    override fun driveCar(car: Car): Car =
        goOrStopCarAction.castCarAction()
            .let { car.copy(mileage = car.mileage + it.value) }
}

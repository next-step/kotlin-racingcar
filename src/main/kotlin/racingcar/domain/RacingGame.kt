package racingcar.domain

object RacingGame {

    fun race(
        register: RegisterResult,
        times: Int,
        gearFactory: GearFactory,
        onRoundFinish: (car: Car) -> Unit
    ): RaceResult {
        val cars = Car.registerCars(register.participant)
        repeat(times) {
            cars.forEach {
                it.drive(gearFactory.getGear())
                onRoundFinish(it)
            }
        }
        return RaceResult(cars)
    }
}

package racingcar.domain

import racingcar.RandomGear

object RacingGame {

    fun race(register: RegisterResult, times: Int, presentSituation: (car: Car) -> Unit): RaceResult {
        val cars = Car.registerCars(register.participant)
        repeat(times) {
            cars.forEach {
                it.drive(RandomGear.getGear())
                presentSituation(it)
            }
        }
        return RaceResult(cars)
    }
}

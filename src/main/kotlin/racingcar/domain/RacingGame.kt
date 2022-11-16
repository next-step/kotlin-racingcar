package racingcar.domain

import racingcar.RandomGear

object RacingGame {

    fun race(register: RegisterResult, times: Int, onRoundFinish: (car: Car) -> Unit): RaceResult {
        val cars = Car.registerCars(register.participant)
        repeat(times) {
            cars.forEach {
                it.drive(RandomGear.getGear())
                onRoundFinish(it)
            }
        }
        return RaceResult(cars)
    }
}

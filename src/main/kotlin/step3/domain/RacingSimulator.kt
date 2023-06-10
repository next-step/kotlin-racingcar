package step3.domain

/**
 * 레이싱 요청을 받아 레이싱을 수행하는 역할을 하는 클래스 입니다.
 */
class RacingSimulator {

    fun race(raceRequest: RacingRequest): RacingRecord {
        val cars = List(raceRequest.carCount) { Car() }
        val racingCars = RacingCars(cars)
        return racingCars.race(raceRequest.attemptCount)
    }
}

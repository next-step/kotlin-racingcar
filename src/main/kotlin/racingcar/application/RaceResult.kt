package racingcar.application

import racingcar.domain.Car

data class RaceResults(val values: List<RaceResult>) {
    companion object {
        fun from(cars: List<Car>): RaceResults {
            val raceResults = cars.map { car -> RaceResult.from(car) }
            return RaceResults(raceResults)
        }
    }
}

data class RaceResult(val carName: String, val carPosition: Int) {
    companion object {
        fun from(car: Car): RaceResult {
            return RaceResult(carName = car.name, carPosition = car.position)
        }
    }
}

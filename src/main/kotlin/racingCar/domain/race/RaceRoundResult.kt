package racingCar.domain.race

import racingCar.domain.car.CarStatus

data class RaceRoundResult(val carStatuses: Map<String, CarStatus>)

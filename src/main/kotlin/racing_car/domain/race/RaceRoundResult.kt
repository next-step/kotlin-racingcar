package racing_car.domain.race

import racing_car.domain.car.CarStatus

data class RaceRoundResult(val carStatuses: Map<String, CarStatus>)

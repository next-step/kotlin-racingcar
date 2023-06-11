package next.step.racing.service.to

import next.step.racing.domain.car.CarRecord

data class RacingResult(val records: List<List<CarRecord>>, val winners: List<String>)

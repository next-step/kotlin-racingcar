package next.step.racing.domain.racing

import next.step.racing.domain.car.CarRecord

data class RacingResult(val records: List<List<CarRecord>>, val winners: List<String>)

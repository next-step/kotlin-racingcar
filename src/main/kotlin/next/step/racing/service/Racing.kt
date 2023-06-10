package next.step.racing.service

import next.step.racing.domain.car.CarNames
import next.step.racing.domain.car.CarRecord
import next.step.racing.domain.car.Cars
import next.step.racing.service.to.RacingResult
import next.step.racing.service.to.StepCount
import next.step.racing.util.DrivingStrategy

object Racing {
    fun race(carNames: CarNames, stepCnt: StepCount, drivingStrategy: DrivingStrategy): RacingResult {
        val cars = Cars.from(names = carNames)
        val records = mutableListOf<List<CarRecord>>()
        repeat(stepCnt.cnt) {
            records.add(cars.move(drivingStrategy).records())
        }
        return RacingResult(records, cars.winners())
    }
}

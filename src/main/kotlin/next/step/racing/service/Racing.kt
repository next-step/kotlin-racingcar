package next.step.racing.service

import next.step.racing.domain.Cars
import next.step.racing.util.DrivingStrategy

object Racing {
    fun race(carCnt: Int, stepCnt: Int, drivingStrategy: DrivingStrategy): List<List<Int>> {
        val cars = Cars.from(carCnt)
        val positions = mutableListOf<List<Int>>()
        repeat(stepCnt) {
            positions.add(cars.move(drivingStrategy).positions())
        }
        return positions
    }
}

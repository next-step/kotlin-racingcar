package next.step.racing.service

import next.step.racing.domain.Cars

object Racing {
    fun race(carCnt: Int, stepCnt: Int, drivingStrategy: () -> Int): List<List<Int>> {
        var cars = Cars.from(carCnt)
        val positions = mutableListOf<List<Int>>()
        for (step in IntRange(1, stepCnt)) {
            cars = cars.move(drivingStrategy)
            positions.add(cars.positions())
        }
        return positions
    }
}

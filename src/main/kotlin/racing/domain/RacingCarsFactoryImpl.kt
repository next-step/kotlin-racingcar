package racing.domain

import racing.model.Car

class RacingCarsFactoryImpl : RacingCarsFactory {
    override fun createCars(count: Int): List<Car> = mutableListOf<Car>()
        .apply {
            for (i in 0 until count) {
                add(Car())
            }
        }
        .toList()
}

package racing.domain

import racing.model.Car

class RacingCarsFactoryImpl : RacingCarsFactory {
    override fun createCars(count: Int): List<Car> = mutableListOf<Car>()
        .apply {
            repeat(count) {
                add(Car())
            }
        }
        .toList()
}

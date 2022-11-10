package carracing.domain

object Cars {

    fun of(count: Int): List<Car> {
        val cars = mutableListOf<Car>()
        for (value in 1..count) {
            cars.add(Car())
        }
        return cars
    }
}

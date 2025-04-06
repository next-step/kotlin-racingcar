package racingcar.domain.car

data class Winners(val cars: List<Car>) {
    companion object {
        fun of(cars: List<Car>): Winners {
            val maxPosition = cars.maxOf { it.position }
            return Winners(cars.filter { it.position == maxPosition })
        }
    }
}

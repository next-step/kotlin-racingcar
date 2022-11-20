package racingcar.domain

enum class VictoryCondition {
    Longest {
        override fun announceWinner(cars: List<Car>): List<Car> {
            val maximumPosition = cars.maxOf { car -> car.position }
            return cars.filter { car -> car.position == maximumPosition }
        }
    },
    Shortest {
        override fun announceWinner(cars: List<Car>): List<Car> {
            val minimumPosition = cars.minOf { car -> car.position }
            return cars.filter { car -> car.position == minimumPosition }
        }
    };

    abstract fun announceWinner(cars: List<Car>): List<Car>
}

package racingcar

enum class VictoryCondition {
    Longest {
        override fun announceWinner(cars: List<Car>): List<Car> {
            val maximumProgress = cars.maxOf { car -> car.progress }
            return cars.filter { car -> car.progress == maximumProgress }
        }
    },
    Shortest {
        override fun announceWinner(cars: List<Car>): List<Car> {
            val minimumProgress = cars.minOf { car -> car.progress }
            return cars.filter { car -> car.progress == minimumProgress }
        }
    };

    abstract fun announceWinner(cars: List<Car>): List<Car>
}

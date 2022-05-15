package racing.model

data class Round(val cars: List<Car>) {
    companion object {
        const val GO_THRESHOLD_VALUE = 4
    }

    fun next(randomNumbers: List<Int>): Round {
        return Round(
            cars.mapIndexed { idx, car ->
                if (randomNumbers[idx] >= GO_THRESHOLD_VALUE) {
                    car.go()
                } else {
                    car
                }
            }
        )
    }
}
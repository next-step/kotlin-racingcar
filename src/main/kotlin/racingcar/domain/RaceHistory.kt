package racingcar.domain

data class RaceHistory(var history: List<Cars>) {

    fun add(cars: Cars) {
        history = history + cars
    }

    fun getWinners(): Cars {
        val lastCars = history.last()
        return lastCars.getWinners()
    }
    // }
}

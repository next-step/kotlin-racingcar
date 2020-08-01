package racing.domain

import racing.infrastructure.RacingCar

class Winner {

    fun get(result: List<Cars>): Cars {
        val cars = result.last()
        val longestDistance = RacingCar().longestDistance(cars)

        return cars
            .filter { it.distance == longestDistance }
    }
}

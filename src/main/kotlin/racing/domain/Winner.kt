package racing.domain

import racing.infrastructure.RacingGame

class Winner {

    fun get(result: List<Cars>): Cars {
        val cars = result.last()
        val longestDistance = RacingGame().longestDistance(cars)

        return cars
            .filter { it.distance == longestDistance }
    }
}

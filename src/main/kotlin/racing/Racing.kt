package racing

import mu.KLogging
import racing.View.display

class Racing(
    private val carCount: CarCount,
    private val roundCount: RoundCount,
    private val distanceService: DistanceService = DistanceService()
) {

    companion object : KLogging()

    fun start() {
        game(roundList = roundCount.toList(), carList = carCount.toList())
            .display()
    }

    fun game(roundList: List<Count>, carList: List<Count>): List<List<Car>> {
        val games: MutableList<List<Car>> = mutableListOf()

        roundList.forEachIndexed { index, _ ->
            val prevGame: List<Car> = games.getOrElse(index - 1) { emptyList() }
            games.add(round(carList = carList, prevGame = prevGame).toMutableList())
        }

        return games
    }


    fun round(carList: List<Count>, prevGame: List<Car>): List<Car> {
        return carList.map { name ->
            val prevDistance = prevGame.firstOrNull { it.name == name }?.distance ?: 0
            val newDistance = distanceService.get()

            logger.debug { "car : [$name], prevDistance : $prevDistance, newDistance : $newDistance" }
            return@map Car(name = name, distance = prevDistance + newDistance)
        }
    }


}


package week1.step4.racinggame.domain

import kotlin.random.Random

fun interface RandomNumberGenerator {
    fun generate(): Int
}

class RacingGame(
    carRoster: CarRoster,
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator { Random.nextInt(0, 10) },
) {
    val cars: List<Car> = carRoster.createCars()

    fun round() {
        cars.forEach {
            it.move(RandomNumber(randomNumberGenerator.generate()))
        }
    }

    fun getWinners(): List<Car> {
        return cars.filter { candidate ->
            cars.all { other -> candidate.isWin(other) || candidate.isDraw(other) }
        }
    }
}

package step3

import java.util.Random

class RaceSeries(private val carCount: Int, private val raceRounds: Int) {

    private val random = Random()

    fun start() = (0 until raceRounds).map { n ->
        val cars = (0 until carCount).map {
            val isForward = random.nextInt(10) > 4
            Car(isForward)
        }
        Round(roundNumber = n, cars)
    }
}
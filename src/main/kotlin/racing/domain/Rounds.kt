package racing.domain

class Rounds(private val maxRound: Int) {

    private var currentRound: Int = 0

    fun hasNext(): Boolean = currentRound < maxRound

    fun play(cars: Cars): Cars {
        currentRound++
        return cars.move()
    }
}

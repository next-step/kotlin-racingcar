package camp.nextstep.edu.step3.racing

class Racing private constructor(carNumber: Int, private val moveCount: Int) {

    private var ended = false
    private val carTracks = HashMap<Car, Track>()

    init {
        IntRange(0, carNumber - 1).forEach {
            carTracks[Car(it)] = Track(moveCount)
        }
    }

    fun start() {
        for ((car, track) in carTracks) {
            car.raceOn(track, moveCount)
        }

        ended = true
    }

    fun result(): Map<Car, Track> {
        if (!ended) throw RuntimeException("racing is not ended")

        return carTracks
    }

    companion object {
        fun new(carNumber: Int, moveCount: Int): Racing {
            return Racing(carNumber, moveCount)
        }
    }
}

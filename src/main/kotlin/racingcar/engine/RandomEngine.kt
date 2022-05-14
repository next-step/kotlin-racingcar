package racingcar.engine

class RandomEngine {

    fun accelerate(): Distance {
        return Distance((0..1).random())
    }
}

package racingcar

class RandomForceGenerator : ForceGenerator {
    override fun generate(): Force {
        return Force((0..9).random())
    }
}

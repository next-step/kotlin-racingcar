package racingcar

class RandomPowerEngine : Engine {
    override fun powerUp(): Int = (0..9).random()
}

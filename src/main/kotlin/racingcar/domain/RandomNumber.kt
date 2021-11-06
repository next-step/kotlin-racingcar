package racingcar.domain

class RandomNumber: NumberStrategy {
    override fun getNumber(): Int {
        return (0..9).random()
    }
}
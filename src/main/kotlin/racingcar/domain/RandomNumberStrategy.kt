package racingcar.domain

class RandomNumberStrategy: NumberStrategy {
    override fun getNumber(): Int {
        return (0..9).random()
    }
}
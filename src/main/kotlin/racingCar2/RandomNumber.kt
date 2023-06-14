package racingCar2

interface RandomNumber {
    fun getRandomNumber(): Int
}

class RandomNumberGenerator : RandomNumber {
    override fun getRandomNumber(): Int {
        return (0..9).random()
    }
}

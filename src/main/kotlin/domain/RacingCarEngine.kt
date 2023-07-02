package domain

class RacingCarEngine : Engine {
    override fun getRandomNumber(): Int {
        return (0..9).random()
    }
}

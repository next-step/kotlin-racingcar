package step3.racingcar

class CarEngine : Engine {
    override fun move(): Boolean {
        return isCarMove()
    }

    private fun isCarMove() = (0..9).random() >= GO_NUMBER

    companion object {
        private const val GO_NUMBER = 4
    }
}

package racing.controller

fun interface GameUserInputInterface {
    fun generateNextNumber(): Int
}

class RandomNumberInput : GameUserInputInterface {
    override fun generateNextNumber(): Int {
        return (0..9).random()
    }
}

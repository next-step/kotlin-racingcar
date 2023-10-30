package racinggame

interface Dice {
    fun pitch(): DiceResult
}

class RandomDice : Dice {
    override fun pitch() = ((0..10).random()).let {
        DiceResult.getResult(it)
    }
}

class ForwardDice : Dice {
    override fun pitch() = (4).let {
        DiceResult.getResult(it)
    }
}

enum class DiceResult(val apply: (Int) -> Int) {
    STOP({ it }),
    FORWARD({ it + 1 });

    companion object {
        fun getResult(diceResult: Int) = diceResult.let {
            if (it >= 4) {
                FORWARD
            } else {
                STOP
            }
        }
    }
}

package racing.model

import racing.model.Number.Companion.MAX_NUMBER
import racing.model.Number.Companion.MIN_NUMBER

object RandomNumberGenerator {

    fun generateRandomNumber(): Number {
        val randomNumber = (MIN_NUMBER..MAX_NUMBER).random()
        return Number(randomNumber)
    }
}

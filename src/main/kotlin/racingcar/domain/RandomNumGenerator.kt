package racingcar.domain

object RandomNumGenerator {

    fun generate(min: Int, max: Int): Int = (min..max).random()
}

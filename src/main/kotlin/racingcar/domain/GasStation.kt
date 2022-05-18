package racingcar.domain

class GasStation {

    fun getRandomGas(): Int {
        return (0..9).random()
    }
}

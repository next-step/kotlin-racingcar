package racing.reader

class CarRacingReader {

    fun readNumberOfCar() = readIntValue()

    fun readNumberOfTry() = readIntValue()

    private fun readIntValue() = readLine()?.toInt() ?: throw NumberFormatException()
}

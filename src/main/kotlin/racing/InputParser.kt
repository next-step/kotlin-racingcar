package racing

object InputParser {

    private const val INPUT_SEPERATOR = ","
    fun parse(carNames: String) : List<String> {
        return carNames.split(INPUT_SEPERATOR)
    }

}
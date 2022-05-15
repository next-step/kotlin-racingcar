package racingcar.view.input.parser

class CarNamesInputParser(private val maxLengthOfName: Int) : InputParser<List<String>> {

    companion object {
        private const val ERROR_MESSAGE_NO_INPUT = "잘못된 이름 입니다. 이름을 ,로 구분하여 입력해 주세요."
    }

    override fun parseValue(inputString: String?): List<String> {
        val names = inputString.toBlankRemovedToken(",")
        val namesOverLength = names.filter { it.length > maxLengthOfName }

        require(names.isNotEmpty()) { ERROR_MESSAGE_NO_INPUT }
        require(namesOverLength.isEmpty()) { makeOverLengthErrorMessage(namesOverLength) }

        return names
    }

    private fun makeOverLengthErrorMessage(names: Collection<String>) =
        "[길이 > $maxLengthOfName]  인 이름이 있습니다 : ${names.joinToString(",", "[", "]")}"

    private fun String?.toBlankRemovedToken(delimiter: String) = this?.split(delimiter)
        ?.filterNot { it.isBlank() }
        ?.map { it.trim() }
        ?: listOf()
}

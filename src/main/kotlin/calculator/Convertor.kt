package calculator

class Convertor {
    /**
     * 입력된 수식 문자열을 화이트스페이스를 기준으로 split하여 리스트로 반환한다.
     */
    fun splitNumberSentenceToList(numberSentence: String?): List<String> {
        if (numberSentence == null || numberSentence.isBlank() || numberSentence.isEmpty())
            throw IllegalArgumentException("입력값이 null이거나 빈 공백이 아니여야합니다.")

        val splitByWhitespaceList = numberSentence.split(" ")
        if (splitByWhitespaceList.size < 3) throw IllegalArgumentException("숫자 및 기호를 포함하여 3개 이상을 입력하셔야합니다.")
        if (splitByWhitespaceList.first().toIntOrNull() == null || splitByWhitespaceList.last().toIntOrNull() == null)
            throw IllegalArgumentException("수식의 시작 및 끝은 숫자여야합니다.")

        return splitByWhitespaceList
    }

    fun getMathematicalSigns(input: String) = MathematicalSign.getBySign(input)?: throw IllegalArgumentException("'$input'은 허용되지않은 기호입니다.(+, -, *, / 만 허용됩니다.)")

    fun getNumber(input: String) = input.toIntOrNull() ?: throw IllegalArgumentException("'$input'은 숫자가 아닙니다.")
}
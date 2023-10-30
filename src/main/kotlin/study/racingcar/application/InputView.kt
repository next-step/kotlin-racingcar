package study.racingcar.application

/**
 * 값을 입력 받는다.
 * */

class InputView(
    val reader: Reader) {
    /**
     * stdin 으로 입력을 받고, 입력받은 값을 검증해서 InputValue 로 반환한다.
     * @param 입력을 받는 Reader 객체
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    fun getInput(): InputValue {
        val carTotalNum: Int = inputNumber("자동차 대수를 입력하세요: ")
        val tryCount: Int = inputNumber("시도할 횟수를 입력하세요: ")

        if (carTotalNum < 1 || tryCount < 1) {
            throw IllegalArgumentException("자동차 대수와 시도 횟수는 1 이상이어야 합니다.")
        }
        return InputValue(carTotalNum, tryCount)
    }

    // TODO : 검증역할을 별도의 객체로 분리하는게 SRP 관점에서 더 적합할 것 같습니다.
    /**
     * 입력으로 문자열을 받고 1 이상의 정수형의 숫자인지 검증 후 Int 로 변환해서 반환한다.
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    private fun String.checkIsProperIntFormat(): Int {
        val num = try {
            toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력 값이 정수형의 숫자가 아닙니다. 숫자를 입력해주세요.")
        }


    /**
     * 입력으로 받은 문자열을 정수형으로 변환해서 반환한다.
     * @param prompt 입력을 유도하는 문자열
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    fun inputNumber(prompt: String): Int {
        while (true) {
            try {
                print(prompt)
                val input: String = reader.read() ?: throw IllegalArgumentException("입력 값이 null 입니다.")
                return Number(input).checkIsProperIntFormat()
            } catch (e: Exception) {
                println("[$e] 입력 숫자를 확인해주세요.")
            }
        }
    }
}

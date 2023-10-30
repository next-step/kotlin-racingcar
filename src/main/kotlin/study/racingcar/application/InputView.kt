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

        val inputValue = InputValue(carTotalNum, tryCount)
        inputValue.validate()

        return inputValue
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

package racingcar

const val NAME_SPLIT_FORMAT = ","
class InputView {

    fun carCountInput(): Int {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        require(carCount > 0) { "자동차 대수는 최소 1대 이상 필요합니다.input:$carCount" }
        return carCount
    }

    fun playCountInput(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val playCount = readLine()!!.toInt()
        require(playCount > 0) { "시도 횟수는  최소 1번 이상 필요합니다. input:$playCount" }
        return playCount
    }

    fun carNamesInput(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readLine()!!

        val names = carNames.split(NAME_SPLIT_FORMAT)

        require(names.isNotEmpty()) { "자동차 이름은 최소 1개 이상 필요합니다. input $carNames" }

        return names
    }
}

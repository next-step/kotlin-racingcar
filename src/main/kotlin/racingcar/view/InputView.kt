package racingcar.view

private const val CARNAME_STRING = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."

private const val TRYNUM_STRING = "시도할 횟수는 몇 회인가요?"
private const val DRIVER_NAME_DELIMITER = ","

object InputView {
    fun getCarName(): List<String> {
        println(CARNAME_STRING)
        return readln().split(DRIVER_NAME_DELIMITER)
    }

    fun getTryNum(): Int {
        println(TRYNUM_STRING)
        return readln().toInt()
    }
}

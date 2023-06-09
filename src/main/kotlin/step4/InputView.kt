package step4

private const val CARNUM_STRING = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."

private const val TRYNUM_STRING = "시도할 횟수는 몇 회인가요?"

object InputView {
    fun getCarNames(): String {
        println(CARNUM_STRING)
        return readLine()!!
    }

    fun getTryNum(): Int {
        println(TRYNUM_STRING)
        return readLine()!!.toInt()
    }
}


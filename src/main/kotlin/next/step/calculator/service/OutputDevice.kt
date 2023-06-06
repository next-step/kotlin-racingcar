package next.step.calculator.service

object OutputDevice {
    private const val UNKNOWN_ERR_MSG = "알 수 없는 에러가 발생했습니다."
    fun showResult(command: String, result: Int) {
        println("$command = $result")
    }

    fun showError(msg: String?) {
        println(msg ?: UNKNOWN_ERR_MSG)
    }
}

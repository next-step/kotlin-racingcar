package calculator.interfaces.output

object OutputConsole {

    private const val RESULT = "결과"
    private const val FINAL_RESULT_COMMENT = "짜잔 $RESULT 가 나왔어요!"

    fun output(result: String) {
        println(FINAL_RESULT_COMMENT)
        println("$RESULT: $result")
    }
}

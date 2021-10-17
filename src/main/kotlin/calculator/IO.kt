package calculator

object IO {

    fun getExpression(): String {
        println("식을 입력해주세요")
        return readLine() ?: throw IllegalArgumentException("null은 입력으로 허용되지 않습니다")
    }

    fun printResult(result: Double) {
        println("결과는 ${String.format("%.5f", result)}입니다.")
    }
}

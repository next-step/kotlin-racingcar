object InputView {
    fun getAnswerTo(value: String): Int {
        println(value)
        return readLine()!!.toInt()
    }

    fun getCarNames(value: String): List<String> {
        println(value)
        return readLine()!!.split(",")
    }
}

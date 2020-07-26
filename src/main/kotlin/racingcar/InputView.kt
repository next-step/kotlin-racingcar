object InputView {
    fun getAnswerTo(value: String): Int {
        println(value)
        return readLine()!!.toInt()
    }
}

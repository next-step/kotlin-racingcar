object ResultView {

    private const val NEXT_LINE = "\n"
    private const val PROGRESS_STRING = "-"
    fun showResult(carList: MutableList<Car>, actionCount: Int) {
        println("실행 결과")
        for (i in 0 until actionCount) {
            carList.forEach {
                val progressString = StringBuffer(PROGRESS_STRING)
                repeat(it.getCarProgress()) {
                    progressString.append(PROGRESS_STRING)
                }
                println("${it.name} : ${progressString.toString()}")
            }
            print(NEXT_LINE)
        }
    }
}

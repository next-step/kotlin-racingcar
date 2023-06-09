object ResultView {

    private const val NEXT_LINE = "\n"
    fun showResult(carList: MutableList<Car>, actionCount: Int) {
        println("실행 결과")
        for (i in 0 until actionCount) {
            carList.forEach {
                println(it.getCarProgress())
            }
            print(NEXT_LINE)
        }
    }
}

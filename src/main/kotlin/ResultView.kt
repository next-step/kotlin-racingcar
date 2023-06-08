class ResultView {

    fun showResult(carList : ArrayList<Car>, actionCount : Int) {
        println("실행 결과")
        for(i in 0 until actionCount) {
            carList.forEach {
                println(it.getCarProgress())
            }
            print("\n")
        }
    }
}
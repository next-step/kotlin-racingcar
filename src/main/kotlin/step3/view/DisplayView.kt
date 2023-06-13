package step3.view


object DisplayView {
    /**
     * 경주가 시작되는 것을 알린다.
     */
    fun displayHeader() {
        println("\n실행결과")
    }

    /**
     * 한 번 진행이 될 때마다 자동차의 상태를 화면에 출력한다.
     */
    fun displayCarPosition(carList: List<List<String>>) {
        for (car in carList) {
            val carString = car.joinToString("")
            println(carString)
        }
        println()
    }
}
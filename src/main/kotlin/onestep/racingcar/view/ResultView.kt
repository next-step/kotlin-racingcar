package onestep.racingcar.view

class ResultView {
    companion object {
        private const val INPUT_NUMBER_OF_CAR = "##레이싱##"
    }

    fun showResult(list: List<String>) {
        println(INPUT_NUMBER_OF_CAR)
        list.map {
            println(it)
        }
    }
}

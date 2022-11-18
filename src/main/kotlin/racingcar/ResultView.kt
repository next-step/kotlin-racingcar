package racingcar

import racingcar.model.CarRacer

class ResultView {

    fun show(result: MutableList<List<CarRacer>>) {
        println("")
        println("실행 결과")
        result.forEach {
            saveGameResult(it)
        }
    }

    private fun saveGameResult(carRacers: List<CarRacer>) {
        carRacers.forEach { racer ->
            var result = ""
            repeat(racer.position) { result += "-" }
            println(result)
        }

        println("")
    }
}

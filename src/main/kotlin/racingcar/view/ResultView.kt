package racingcar.view

import racingcar.domain.Car

class ResultView {

    fun action(carList: List<Car>) {
        carList.forEach { println("${it.carName} : " + ICON.repeat(it.distance)) }
    }

    fun victoryCar(victoryCarList: List<Car>) {
        val victoryCarNameBuilder = StringBuilder()

        for (index in 0 until victoryCarList.lastIndex) {
            victoryCarNameBuilder.append("${victoryCarList[index]},")
        }
        victoryCarNameBuilder.append(victoryCarList.last().carName)

        println(victoryCarNameBuilder.toString() + VICTORY_SUFFIX)
    }

    companion object {
        private const val ICON = "\uD83C\uDFCE️"
        private const val VICTORY_SUFFIX = "가 최종 우승했습니다다."
    }
}

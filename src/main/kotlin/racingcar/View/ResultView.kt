package racingcar.View

import racingcar.Driver

object ResultView {
    fun printResult(tryCount: Int, driverList: List<Driver>) {
        println("\n실행 결과")

        repeat(tryCount) { idx ->
            driverList.forEach { driver ->
                println("-".repeat(driver.driveRecord[idx]))
            }
            println("")
        }
    }
}

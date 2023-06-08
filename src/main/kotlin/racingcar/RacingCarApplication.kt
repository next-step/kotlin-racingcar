package racingcar
import racingcar.domain.Cars

object RacingCarApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        println("자동차 대수는 몇 대 인가요?")
        val numberOfCars = readln().toInt()
        val cars = Cars(numberOfCars)

        println("시도할 회수는 몇 회 인가요?")
        val numberOfAttempts = readln().toInt()

        println("실행 결과")
        for (i in 0 until numberOfAttempts) {
            cars.attempt()
            cars.scores.forEach { score: Int ->
                for (i in 0 until score) {
                    print("-")
                }
                println()
            }
            println()
        }
    }
}

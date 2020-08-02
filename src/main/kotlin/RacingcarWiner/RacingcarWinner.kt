package RacingcarWiner

object InputView {

    fun inputcircuitnumber(): Int {
        println("Please Enter circuit number :")
        return readLine()!!.toInt()
    }

    fun inputcarname(): RacingGame {
        println("자동차 이름을 등록해주세요 : (이름은 (,) 쉼표를 기준으로 구분)")
        return RacingGame(readLine()!!.toString())
    }
}

class OutputView() {
    fun printcircuit(cars: MutableList<Car>) {
        cars.forEach({ cars -> println("${cars.name} :${result.repeat(cars.position)}") })
    }

    fun distinctprint() {
        println(distinct)
    }

    fun printwinner(winners: List<Car>) {
        winners.map({ winner -> print("최종 우승은 ${winner.name} 입니다.") })
    }

    companion object {
        private val result = "-"
        private val distinct = " "
    }
}

class Car(name: String, position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    var cars: MutableList<Car> = mutableListOf()

    val name: String = name

    // 0..9 적용 피드백 반영했습니다.
    fun move() {
        if ((0..9).random() >= FORWARD_Number) position++
    }

    fun isIn(position: Int): Boolean = this.position == position

    private fun maxPosition(): Int? = cars.map { it.position }.max()
        ?: 0    //엘비스 프레슬리???

    // 상수 컴패니언 오프젝트 반영 했습니다.
    companion object {

        private const val DEFAULT_POSITION = 0
        private const val FORWARD_Number = 4
    }
}

class RacingGame(carNames: String) {



    init {
        // 이름을 split해 자동차 초기화
        val carlist = carNames.trim().split(",")
        for (car in carlist) {
            cars.add(Car(car))
        }
    }

    fun race() {

        for (i in 0 until InputView.inputcircuitnumber()) {
            cars.forEach { carlist -> carlist.move() }
            OutputView().printcircuit(cars)
            OutputView().distinctprint()
        }
    }

    fun findWinners(): List<Car> {

        val max = maxPosition()
        val winners = cars.filter { it.isIn(max!!) }
        OutputView().printwinner(winners)
        return winners
    }

    companion object {
        private var cars = mutableListOf<Car>()
    }

    private fun maxPosition(): Int? = cars.map { it.position }.max()
        ?: 0    //엘비스 프레슬리???
}

fun main() {
    val cars = InputView.inputcarname()
    cars.race()
    cars.findWinners()
}

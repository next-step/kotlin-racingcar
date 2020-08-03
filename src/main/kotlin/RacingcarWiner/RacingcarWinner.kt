package RacingcarWiner

object InputView {

    fun inputcircuitnumber(): Int {
        println("Please Enter circuit number :")
        return readLine()!!.toInt()
    }

    fun inputcarname(): String {
        println("자동차 이름을 등록해주세요 : (이름은 (,) 쉼표를 기준으로 구분)")
        return readLine()!!.toString()
    }
}

class OutputView() {
    fun printcircuit(cars: MutableList<Car>) {
        cars.forEach({ println("${it.name} :${result.repeat(it.position)}") })
        println(distinct)
    }

    fun printwinner(winners: List<Car>) {
        val winnerslist = winners.map { it.name }.toString().replace("[", "").replace("]", "")
        println("${winnerslist}가 최종 우승 했습니다.")
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

    fun isRacing() {
        InputView.inputcircuitnumber()
    }

    private fun maxPosition(): Int? = cars.map { it.position }.max()
        ?: 0 // 엘비스 프레슬리???

    // 상수 컴패니언 오프젝트 반영 했습니다.
    companion object {

        private const val DEFAULT_POSITION = 0
        private const val FORWARD_Number = 4
    }
}

class RacingGame(carNames: String, circuitNo: Int) {
    val circuitNo = circuitNo

    init {
        // 이름을 split해 자동차 초기화
        val carlist = carNames.trim().split(",")
        for (car in carlist) {
            cars.add(Car(car))
        }
    }

    fun isRacing(): Boolean {
        DEFAULT_CIRCUIT++
        return DEFAULT_CIRCUIT < circuitNo + 1
    }

    fun race(): MutableList<Car> {
        cars.forEach { carlist -> carlist.move() }
        return cars
    }

    fun findWinners(): List<Car> {

        val max = maxPosition()
        return cars.filter { it.isIn(max!!) }
    }

    companion object {
        private var cars = mutableListOf<Car>()
        private var DEFAULT_CIRCUIT = 0
    }

    // 엘비스 프레슬리???
    private fun maxPosition(): Int? = cars.map { it.position }.max() ?: 0
}

fun main() {
    val carsName = InputView.inputcarname()
    val tryNo = InputView.inputcircuitnumber()
    val racinggame = RacingGame(carsName, tryNo)
    while (racinggame.isRacing()) {
        val cars = racinggame.race()
        OutputView().printcircuit(cars)
    }
    val winners = racinggame.findWinners()
    OutputView().printwinner(winners)
}

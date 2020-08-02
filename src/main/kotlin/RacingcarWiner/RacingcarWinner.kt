package RacingcarWiner

object InputView {

    fun inputcircuitnumber(): Int {
        println("Please Enter circuit number :")
        return readLine()!!.toInt()
    }

    fun inputcarname(): List<String> {
        println("자동차 이름을 등록해주세요 : (이름은 (,) 쉼표를 기준으로 구분)")
        return readLine()!!.trim().split(",")
    }
}

class OutputView() {
    fun printcircuit(cars: MutableList<Car>) {
        cars.forEach({ cars -> println("${cars.name} :${result.repeat(cars.position)}") })
    }

    fun distinctprint() {
        println(distinct)
    }

    companion object {
        private val result = "-"
        private val distinct = " "
    }
}

class Car(name: String, position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    val cars = listOf<Car>()

    val name: String = name

    // 0..9 적용 피드백 반영했습니다.
    fun move() {
        if ((0..9).random() >= FORWARD_Number) position++
    }

    fun findWinner(): List<Car> {
        val max = cars.map { it.position }.max()
        return cars.filter { it.position == max }
    }

    // 상수 컴패니언 오프젝트 반영 했습니다.
    companion object {

        private const val DEFAULT_POSITION = 0
        private const val FORWARD_Number = 4
    }
}

fun main() {
    val cars = InputView.inputcarname()
    val circuit = InputView.inputcircuitnumber()
    var carlist = mutableListOf<Car>()
    for (car in cars) {
        carlist.add(Car(car))
    }

    for (i in 0 until circuit) {
        carlist.forEach { carlist -> carlist.move() }
        OutputView().printcircuit(carlist)
        OutputView().distinctprint()
    }
    // 저번 수업때 알려주신대로 findwinner를 사용하려고 했습니다만 결국 해내지 못하여 하단과 같이 구현을 했습니다. 힌트를 주시면 반영 하겠습니다.
    // println(carlist.forEach{carlist -> carlist.findWinner()})

    val winner = carlist.maxBy { it.position ?: 0 }
    if (winner != null) println("${winner.name}가 최종 우승했습니다.")
}

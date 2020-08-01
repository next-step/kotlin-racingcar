class InputView {
    fun inputcarnumber(): Int {
        print("Please Enter cars number :")
        return readLine()!!.toInt()
    }

    fun inputcircuitnumber(): Int {
        print("Please Enter circuit number :")
        return readLine()!!.toInt()
    }
}

class OutputView() {
    fun printcircuit(number: Int) {
        println(result.repeat(number))
    }

    companion object {
        private val result = "_"
    }
}

class Cars(position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    // 0..9 적용 피드백 반영했습니다.
    fun move() {
        if ((0..9).random() >= FORWARD_Number) position++
    }

    // 상수 컴패니언 오프젝트 반영 했습니다.
    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_Number = 4
    }
}

// 클래스에 생성자를 자료형을 클래스로 설정하는 법을 구현하지 못하여 for 문을 메인 메소드에다가 만들었습니다.
fun main() {
    val cars = InputView().inputcarnumber()
    val circuits = InputView().inputcircuitnumber()
    val carlist = MutableList(cars) { index -> Cars() }
    for (i in 0..circuits - 1) {
        for (car in carlist) {
            car.move()
            OutputView().printcircuit(car.position)
        }
        println(" ")
    }
}

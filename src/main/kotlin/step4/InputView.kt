package step4

class InputView {
    companion object {
        private const val CARNAME_DELIMITER = ","

        fun getCars(): List<Car> {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            return readCars()
        }

        private fun readCars(): List<Car> {
            val str = readLine()
            if (str.isNullOrEmpty()) {
                println("잘못된 입력입니다. 다시 입력해주세요.")
                return readCars()
            }
            return str.split(CARNAME_DELIMITER).map { Car.create(it) }
        }

        fun getNumTries(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readInt()
        }

        private fun readInt(): Int {
            val str = readLine()
            if (str.isNullOrEmpty() || !str.all { it.isDigit() }) {
                println("잘못된 입력입니다. 다시 입력해주세요.")
                return readInt()
            }
            return str.toInt()
        }
    }
}

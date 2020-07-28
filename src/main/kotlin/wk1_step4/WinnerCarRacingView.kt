package wk1_step4

import java.lang.StringBuilder

object WinnerCarRacingView {

    fun showFirstInstruction() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun checkCarsValidation(input: String?) {
        if (input == null || input.isEmpty()) {
            throw NullPointerException("자동차 이름을 입력해주세요.")
        }
        if (input.contains(" ")) {
            throw WinnerCarRacingException("공백 없이 자동차이름과 쉼표만 입력해주세요")
        }
        if (!input.matches(Regex("[a-z|A-Z|,]*")))
            throw WinnerCarRacingException("자동차 이름 입력란에는 영문과 `,` 만 포함될 수 있습니다.")
        if (input.endsWith(",")) {
            throw WinnerCarRacingException("`,`는 자동차 이름 사이에만 올 수 있습니다.")
        }
    }

    fun parsingCars(input: String): List<Car> {
        checkCarsValidation(input)
        val names = input.split(",")
        var nameLength: Int = 0
        val cars = mutableListOf<Car>()
        for (name: String in names) {
            nameLength = name.length.coerceAtLeast(nameLength)
            cars.add(Car(name, 0))
        }
        if (nameLength > 5) {
            throw WinnerCarRacingException("자동차 이름은 5자를 넘어갈 수 없습니다.")
        }
        return cars.toList()
    }

    fun showSecondInstruction() {
        println("시도할 횟수는 몇 회인가요?")
    }

    @Throws(NumberFormatException::class)
    fun checkCountValidation(input: String?): Int {
        if (input == null || input.isEmpty()) {
            throw NullPointerException("숫자를 입력해주세요.")
        }
        val number: Int = input.toInt()
        if (number < 1) throw ArithmeticException("0 보다 큰 숫자를 입력해주세요")
        return number
    }

    fun showCarMovement(cars: List<Car>) {
        for (car in cars) {
            print(car.name + " : ")
            showMovement(car.position)
            println()
        }
        println()
    }

    private fun showMovement(count: Int) {
        for (i in 1..count) {
            print("-")
        }
    }

    fun showResult(cars: List<Car>) {
        val result: StringBuilder = StringBuilder()
        for (car in cars) {
            result.append(car.name).append(", ")
        }
        result.delete(result.length - 2, result.length)
        print(result.toString() + "가 최종 우승했습니다.")
    }
}

package race

class CarRaceInputView {

    fun getStartInformation(): RaceStartInformation {
        return RaceStartInformation(getCarNames(), getNumberOfAttempts())
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readCommaSeparatedStrings()
    }

    private fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readInt()
    }

    private tailrec fun readInt(): Int {
        val enteredInt = readln().toIntOrNull()
        if (enteredInt != null) return enteredInt
        println("다시 입력해 주세요.")
        return readInt()
    }

    private tailrec fun readCommaSeparatedStrings(): List<String> {
        val enteredString = readlnOrNull()
        if (enteredString != null) return enteredString.split(",")
        println("다시 입력해 주세요.")
        return readCommaSeparatedStrings()
    }
}

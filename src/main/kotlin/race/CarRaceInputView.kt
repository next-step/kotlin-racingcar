package race

class CarRaceInputView {

    fun getStartInformation(): RaceStartInformation {
        return RaceStartInformation(getNumberOfCars(), getNumberOfAttempts())
    }

    private fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readInt()
    }

    private fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readInt()
    }

    private fun readInt(): Int {
        while (true) {
            runCatching {
                readln().toInt()
            }.onSuccess {
                return it
            }.onFailure {
                println("다시 입력해 주세요.")
            }
        }
    }
}

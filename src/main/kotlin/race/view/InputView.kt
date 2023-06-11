package race.view

object InputView {

    private const val DELIMITER = ","
    fun inputRacers(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val racers = readln().split(DELIMITER)
        racers.forEach {
            it.validRacerName()
        }
        return racers
    }

    fun inputNumberOfRace(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

    private fun String.validRacerName(){
        require(this.length > 5){
            "자동차 이름은 5자를 초과할 수 없다."
        }
    }
}

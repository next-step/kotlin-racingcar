package racingcar

fun main() {
    print("경주에 참여할 자동차 대수는 몇 대인가요? ")
    val numberOfParticipantsInput = readLine()
    require(!numberOfParticipantsInput.isNullOrBlank()) { "자동차 대수 입력값은 빈 값이거나, 공백일 수 없습니다." }
    val numberOfParticipants = numberOfParticipantsInput.toIntOrNull()
        ?: throw IllegalArgumentException("자동차 대수 입력값은 정수여야 합니다.")
    print("경주는 몇 라운드를 진행할 것인가요? ")
    val roundsInput = readLine()
    require(!roundsInput.isNullOrBlank()) { "라운드 입력값은 빈 값이거나, 공백일 수 없습니다." }
    val rounds = roundsInput.toIntOrNull()
        ?: throw IllegalArgumentException("라운드 입력값은 정수여야 합니다.")
    val racingResults = RaceHost.play(rounds, numberOfParticipants)
    for(i in racingResults.values.indices) {
        println("라운드 - [${racingResults.values[i].round}] 결과")
        racingResults.values[i].values.forEach() {
            println("-".repeat(it))
        }
        println()
    }
}

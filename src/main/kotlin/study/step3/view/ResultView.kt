package study.step3.view

object ResultView {
    fun printRaceResults(raceResults: List<List<String>>) {
        println("\n실행 결과")
        for (attemptResults in raceResults) {
            for (position in attemptResults) {
                print(position)
                print("\n")
            }
            println()
        }
    }
}

package racing

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            startCarRacing()
        }
    }
}
// 1. 자동차 대수만큼 map<Int, String>에 자동차넘버(1,2,3)와 "-" 저장
// 2. 시도할 횟수만큼 반복문
// 3. map<Int, String>의 key를 순회하면서 랜덤값(0~9)이 4이상이면 "-"을 추가
fun startCarRacing() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readln().toInt()

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readln().toInt()

    val carMap = RaceExecutor.prepareCar(carCount)
    RaceExecutor.racingCarRandomly(carMap, tryCount)
}

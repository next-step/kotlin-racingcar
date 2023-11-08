package racingCar.domain.strategy

// Functional Interfce(함수형 인터페이스)란?
// → 오직 하나의 abstract method를 가진 interface이다.
fun interface MoveStrategy {
    fun isMove(): Boolean
}

package step3.racing_car.interfaces

/**
 * 자동차 경주시 이동할 수 있는 객체에 사용
 * */
interface Movable {
    fun move(condition: Int)
    fun getCurrentPosition(): Int
}
package carracing

class CarRacingValidator {

    fun validateCarName(carName: String) {
        if (carName.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }
    
    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
class CarRacingResultView {
    companion object {
        private fun moveOrStop(): Boolean {
            val number: Int = ((Math.random() * 10).toInt())
            return number > 3
        }

        fun showMovement(count: Int) {
            var movement: Int = 0
            for (i in 0..count) {
                if (moveOrStop()) print("-")
            }
            println("")
        }
    }
}

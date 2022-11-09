## 3단계 - 자동차 경주

### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.


### 구현 목록
- Car를 구현
	- track 문자열을 프로퍼티로 가지고 있다.
	- track 문자열에 "-"을 더하는 goForward 메소드를 구현한다.

- RandomGenerator 구현
	- 0..9의 랜덤한 값를 구한다. (파라미터: X, 반환값: Int)
	- 랜덤한 값이 유효한지를 반환한다. (파라미터: Int, 반환값: Boolean)

- RacingGame 구현
	- RandomGenerator 객체를 갖는다.
	- List<Car> 프로퍼티를 갖는다.
	- race 메소드를 구현한다. (파라미터: X, 반환값: List<Car>)
		- cars 컬렉션을 순환하면서 randomGenerator의 유효성 여부의 결과값에 따라 goForward 메소드를 수행한다.

- Output UI 구현 
	- ResultView (출력을 담당)
		- printResult 메소드를 구현한다. (파라미터: List<Car>, 반환값: Unit)

- RacingController 구현
	- setCars(파라미터: carNum: Int, 반환값: Cars)
	- doRacingGame 메소드를 구현한다. (파라미터 : carNum: Int, excuteNum: Int, 반환값: Unit)
		- 차 목록을 세팅한다.
		- 차 목록을 RacingGame에 넘겨준다.
		- RacingGame의 race메소드를 excuteNum만큼 반복 수행한다.
		- OutputUI의 printResult 메소드를 호출한다.

- Input UI 구현
	- InputView (입력을 담당)
	- RacingController의 doRacingGame 메소드를 호출한다.

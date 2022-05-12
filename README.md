# kotlin-racingcar

## 기능 구현 목록표(문자열 계산기)
> 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현한다. 

- [ ] 수식을 입력받는 기능 
  - [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException
  - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException
- [x] (더하기, 빼기 , 곱하기, 나누기) 연산 기능
- [x] 문자열 계산기가 수식을 계산하는 기능

## 자동차 경주
### 3단계 요구 사항
- [x] 자동차 객체를 생성하는 기능
- [x] 자동차가 전진하는 기능
  - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 시도 횟수를 입력받는 기능
  - [x] 시도 횟수가 0이하인 경우 예외를 발생시키는 기능  
  - [x] 잔여 시도횟수가 없을 때, 시도 횟수를 차감시키면 예외를 발생시키는 기능
- [ ] 시도 횟수만큼 자동차를 전진 또는 정지 시키는 기능
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 자동차의 상태를 화면에 출력한다.

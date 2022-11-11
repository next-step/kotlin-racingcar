## 자동차 경주

### 테스트 시나리오

### 입력
- [x] 자동차 이름의 입력이 pobi,crong,honux 일 경우 3대의 자동차 등록이 됨
- [x] 자동차 이름의 입력이 5자를 초과할 경우 IllegalArgumentException 오류
- [x] 자동차 이름의 입력이 공백일 경우 IllegalArgumentException 오류
- [x] 시도할 횟수의 입력 값이 0일 경우 IllegalArgumentException 오류

### 결과
- [x] 자동차 이름이 홍길동이고 현재 위치가 5일경우 "홍길동 : -----" 값을 반환해야함

### 자동차
- [x] 전진 조건일 경우 자동차의 현재 위치가 1 증가함
- [x] 후진 조건일 경우 자동차의 현재 위치 고정

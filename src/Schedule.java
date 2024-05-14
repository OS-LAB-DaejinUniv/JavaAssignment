import java.util.Date;
import java.text.SimpleDateFormat;
// 스케줄 데이터 정의
public class Schedule {
    String title,date,time;
    int priority;
    boolean finished;

    // 클래스 선언
    public Schedule(String title, String date, String time, int priority) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.priority = priority;
    }

    public String getTitle() {return title;}
    public String getDate() {return date;}

    @Override
    public String toString() {
        return "스케줄[" +
                "이름='" + title + '\'' +
                ", 일정='" + date + '\'' +
                ", 시간='" + time + '\'' +
                ", 중요도=" + priority +
                ", 완료여부=" + finished +
                ']';
    }

    // 입력받은 문자열 단어 포함 여부 확인
    public boolean equalTitle(String title){
        return this.title.contains(title);
    }
    // 시작 일정 ~ 종료 일정 범위 판별 , 기간 내 존재 여부 확인
    public boolean isInDateRange(String startDate, String endDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date current = formatter.parse(date);
            Date start = formatter.parse(startDate);
            Date end = formatter.parse(endDate);
            int comparedToStart = current.compareTo(start); // 현재 날짜가 검색 시작날짜와 같으면 0, 이후면 1
            int comparedToEnd = current.compareTo(end); // 현재 날짜가 검색 종료 날짜와 같으면 0, 이전이면 -1
            return comparedToStart >= 0 && comparedToEnd <= 0;
        } catch (Exception e) { return false; }
    }

    // 현재 일정 완료
    public void finish(){
        finished = true;
    }
    // 현재 일정 완료 여부 판독
    public boolean isFinished() {
        return finished;
    }

}

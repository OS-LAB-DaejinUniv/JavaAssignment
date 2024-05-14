
// 주요 기능 처리 클래스
public class ScheduleBox {
    private Schedule[] schedules; // Schedule 객체참조배열 선언
    private int size, cnt; // 배열 크기, 현재 등록된 스케줄 갯수

    public ScheduleBox(int size) {
        this.size = size;
        schedules = new Schedule[size]; // size 변수에 있는 크기만큼 배열 생성
        cnt = 0;
    }
    // 스케줄 생성
    public void addSchedule(String title,String date,String time,int priority) {
        Schedule schedule = new Schedule(title,date,time,priority);
        schedules[cnt++] = schedule;
    }
    // 스케줄 조회(나열)
    public void showSchedule() {
        for(int i = 0; i<cnt; i++) {
            System.out.println(schedules[i]);
        }
    }

    // 스케줄 타이틀 검색 기능 구현
    public void findTitleSchedule(String title){
        for(int i=0; i<cnt; i++)
            if(schedules[i].equalTitle(title)){
                System.out.println(schedules[i]);
            }
    }
    // 스케줄 일자 검색 기능
    public void findDateSchedule(String startDate,String endDate){
        for (int i = 0; i < cnt; i++) {
            if (schedules[i].isInDateRange(startDate, endDate)) {
                System.out.println(schedules[i]);
            }
        }
    }
    // 주어진 타이틀에 해당하는 스케쥴 완료
    public void finishTitleSchedule(String title) {
        for(int i=0; i<cnt; i++) {
            if (schedules[i].equalTitle(title)) {
                schedules[i].finish();
                System.out.println(schedules[i]);
            }
        }
    }
    // 주어진 일자 이전의 모든 스케쥴 완료
    public void finishSchedule(String dateBefore) {
        for (int i = 0; i < cnt; i++) {
            if (schedules[i].isInDateRange("1970/01/01", dateBefore)) {
                schedules[i].finish();
                System.out.println(schedules[i]);
            }
        }
    }
}

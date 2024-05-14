import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int size = 100;
    private static ScheduleBox box = new ScheduleBox(size);

    // 스케줄 생성 메소드
    private static void addSchedule(ScheduleBox box){
        while(true) {
            System.out.print("title : ");
            String title = sc.next();
            if (title.equals("exit")) break;
            System.out.print("date : ");
            String date = sc.next();
            System.out.print("time : ");
            String time = sc.next();
            System.out.print("priority : ");
            int priority = sc.nextInt();
            box.addSchedule(title, date, time, priority); // 스케줄 추가
        }
    }
    // 스케줄 조회 메소드
    private static void showSchedule(){
        box.showSchedule();
    }

    private static void findTitleSchedule(){
        String word;
        System.out.print("검색할 스케줄 타이틀 : ");
        word = sc.next();
        box.findTitleSchedule(word);
    }

    private static void findDateSchedule(){
        String startDate,endDate;
        System.out.print("검색할 스케줄 시작 기간 :");
        startDate = sc.next();
        System.out.print("검색할 스케줄 종료 기간:");
        endDate = sc.next();
        box.findDateSchedule(startDate, endDate);
    }
    // 스케줄 완료(타이틀)
    private static void finishTitleSchedule(){
        Scanner sc = new Scanner(System.in);
        String title;
        System.out.print("완료할 스케줄 타이틀:");
        title = sc.next();

        box.finishTitleSchedule(title);
    }

    private static void finishDateSchedule(){
        Scanner sc = new Scanner(System.in);
        String date;
        System.out.print("스케줄 종료 범위(YYYY-MM-DD) : ");
        date = sc.next();

        box.finishSchedule(date);
    }

    public static void main(String[] args) {

        while(true){
            System.out.print("\n##스케줄 관리 프로그램##\n" +
                    "1. 스케줄 생성\n" +
                    "2. 스케줄 조회\n" +
                    "3. 스케줄 검색(타이틀)\n" +
                    "4. 스케줄 검색(기간)\n" +
                    "5. 스케줄 완료(타이틀)\n" +
                    "6. 스케줄 완료(일자 이전)\n"+
                    "선택 =>");
            int num = sc.nextInt();
            switch(num){
                case 1 -> addSchedule(box);
                case 2 -> showSchedule();
                case 3 -> findTitleSchedule();
                case 4 -> findDateSchedule();
                case 5 -> finishTitleSchedule();
                case 6 -> finishDateSchedule();
            }
        }
    }
}

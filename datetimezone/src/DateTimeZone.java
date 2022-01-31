import java.time.*;
import java.util.Scanner;

public class DateTimeZone {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int year,month,day,hour,minute,second;

        System.out.println("Enter the year of your country");
        year = scanner.nextInt();
        while(year < 1900 || year > 2100){
            System.out.println("Invalid year re-enter again");
            year = scanner.nextInt();
        }

        System.out.println("Enter the month of your country");
        month = scanner.nextInt();
        while(month < 1 || month > 12){
            System.out.println("Invalid month re-enter again");
            month = scanner.nextInt();
        }

        System.out.println("Enter the day of your country");
        day = scanner.nextInt();
        while(day < 1 || day > 31){
            System.out.println("Invalid day re-enter again");
            day = scanner.nextInt();
        }

        System.out.println("Enter the hour of your country");
        hour = scanner.nextInt();
        while (hour < 0 || hour > 23){
            System.out.println("Invalid hour re-enter again");
            hour = scanner.nextInt();
        }

        System.out.println("Enter the minute of your country");
        minute = scanner.nextInt();
        while (minute < 0 || minute > 59){
            System.out.println("Invalid minute re-enter again");
            minute = scanner.nextInt();
        }

        System.out.println("Enter the second of your country");
        second = scanner.nextInt();
        while (second < 0 || second > 59){
            System.out.println("Invalid second re-enter again");
            second = scanner.nextInt();
        }

        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,Clock.systemDefaultZone().getZone());
        ZonedDateTime zdt = zonedDateTime.withZoneSameInstant(ZoneOffset.UTC);

        System.out.println("Time Zone "+ Clock.systemDefaultZone().getZone());
        System.out.println("Local Time "+ localDateTime);
        System.out.println("UTC/GMT Time "+ zdt);
        System.out.println("Epoch Time "+ zdt.toEpochSecond());
        System.out.println("Epoch Time to UTC/GMT "+ Instant.ofEpochSecond(zdt.toEpochSecond()));

    }

}

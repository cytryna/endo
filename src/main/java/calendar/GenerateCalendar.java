package calendar;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GenerateCalendar {

    private List<String> events = new ArrayList<>();
    private static String GLOBAL_TAMPLATE_START ="BEGIN:VCALENDAR\n" +
            "PRODID:-//Google Inc//Google Calendar 70.9054//EN\n" +
            "VERSION:2.0\n" +
            "CALSCALE:GREGORIAN\n" +
            "METHOD:PUBLISH\n" +
            "X-WR-CALNAME:testyimportu\n" +
            "X-WR-TIMEZONE:Europe/Warsaw\n" +
            "X-WR-CALDESC:\n";

    private static String GLOBAL_TAMPLATE_END = "END:VCALENDAR";

    private static final String DATE_HOLDER = "dateHolder";
    private static final String SUMARY_HELDER = "summaryHolder";
    private static String EVENT_TEMPLATE =  "BEGIN:VEVENT\n" +
            "DTSTART:"+ DATE_HOLDER +"T090000Z\n" +
            "DTEND:"+ DATE_HOLDER +"T100000Z\n" +
            "DTSTAMP:20180624T083027Z\n" +
            "CREATED:20180624T082905Z\n" +
            "DESCRIPTION:\n" +
            "LAST-MODIFIED:20180624T083002Z\n" +
            "LOCATION:\n" +
            "SEQUENCE:0\n" +
            "STATUS:CONFIRMED\n" +
            "SUMMARY:"+SUMARY_HELDER+"\n" +
            "TRANSP:OPAQUE\n" +
            "END:VEVENT\n" ;


    public static void main(String[] args) {
        new GenerateCalendar().start();
    }

    private void start() {
        LocalDate eventDate = LocalDate.of(2019, 05, 20);
        double weight = 99;
        DecimalFormat df = new DecimalFormat("#.##");
        for (int k = 0; k < 100; k++) {
//            if (eventDate.isBefore(LocalDate.now())) {
            if (eventDate.isBefore(LocalDate.now())) {
                continue;
            }
            weight = weight + 0.5;
            events.add(prepereEventCalendar(eventDate,  df.format(weight)));
            eventDate = eventDate.minusWeeks(1);
        }
//        Collections.reverse(events);
        StringBuilder stringBuilder = new StringBuilder(GLOBAL_TAMPLATE_START);
        events.stream().forEach(s -> stringBuilder.append(s));
        stringBuilder.append(GLOBAL_TAMPLATE_END);
        System.out.println(stringBuilder.toString());

    }

    private String prepereEventCalendar(LocalDate eventDate, String weight) {
        String event = EVENT_TEMPLATE.replace(DATE_HOLDER, "" + DateTimeFormatter.BASIC_ISO_DATE.format(eventDate));
        event = event.replace(SUMARY_HELDER, "Cel na ten tydzień to "+weight+" kg");
        return event;
    }
}

package calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrinCalendar {

    private List<String> events = new ArrayList<>();
    private static String EVENT_START ="BEGIN:VEVENT";
    private static String EVENT_END ="END:VEVENT";

    private static String GLOBAL_TAMPLATE_END = "END:VCALENDAR";

    private static final String DATE_HOLDER = "dateHolder";
    private static final String SUMARY_HELDER = "summaryHolder";
    private static String EVENT_TEMPLATE =  "BEGIN:VEVENT\n" +
            "DTSTART:"+ DATE_HOLDER +"T090000Z\n" +
            "DTEND:"+ DATE_HOLDER +"T100000Z\n" +
            "DTSTAMP:20170917T083027Z\n" +
            "CREATED:20170917T082905Z\n" +
            "DESCRIPTION:\n" +
            "LAST-MODIFIED:20170917T083002Z\n" +
            "LOCATION:\n" +
            "SEQUENCE:0\n" +
            "STATUS:CONFIRMED\n" +
            "SUMMARY:"+SUMARY_HELDER+"\n" +
            "TRANSP:OPAQUE\n" +
            "END:VEVENT\n" ;

    private void start() {
        try {

            System.err.println(new File(".").getAbsolutePath());
            String stringSearch = "BEGIN:VEVENT";
            BufferedReader bf = new BufferedReader(new FileReader("calendarFile.ics"));

            // Start a line count and declare a string to hold our current line.
            int linecount = 0;
            String line;

            // Let the user know what we are searching for
            System.out.println("Searching for " + stringSearch + " in file...");

            // Loop through each line, stashing the line into our line variable.
            while (( line = bf.readLine()) != null){
                // Increment the count and find the index of the word
                linecount++;
                int indexfound = line.indexOf(stringSearch);
                // If greater than -1, means we found the word
                if (indexfound > -1) {
                    System.err.println(line);
//                    System.out.println("Word was found at position " + indexfound + " on line " + linecount);
                }
            }

            // Close the file after done searching
            bf.close();
        }
        catch (IOException e) {
            System.out.println("IO Error Occurred: " + e.toString());
        }
//
//        LocalDate eventDate = LocalDate.of(2017, 12, 31);
//
//        for (int i = 0; i < 100; i++) {
//            if (eventDate.isBefore(LocalDate.now())) {
//                continue;
//            }
//            events.add(prepereEventCalendar(eventDate, 110 + i));
//            eventDate = eventDate.minusWeeks(1);
//        }
//        Collections.reverse(events);
//        StringBuilder stringBuilder = new StringBuilder(GLOBAL_TAMPLATE_START);
//        events.stream().forEach(s -> stringBuilder.append(s));
//        stringBuilder.append(GLOBAL_TAMPLATE_END);
//        System.out.println(stringBuilder.toString());

    }

    private String prepereEventCalendar(LocalDate eventDate, int weight) {
        String event = EVENT_TEMPLATE.replace(DATE_HOLDER, "" + DateTimeFormatter.BASIC_ISO_DATE.format(eventDate));
        event = event.replace(SUMARY_HELDER, "Powinieneś ważyć "+weight+" kg");
        return event;
    }

    public static void main(String[] args) {
        new PrinCalendar().start();
    }
}

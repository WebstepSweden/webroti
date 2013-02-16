package se.diversify.webroti.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A Repository of meetings
 */
public class Repository {

    private Repository(){
        // Singleton - don't instantiate me please
    }

    private static Map<String, Meeting> meetings = new ConcurrentHashMap<String, Meeting>();

    /**
     * Create a new meeting
     * @return a new meeting
     */
    public static Meeting createMeeting() {
        Meeting meeting = new Meeting(getNextNumber());
        meetings.put(meeting.getId(), meeting);
        return meeting.touch();
    }

    /**
     * Get a meeting given an id, or throws a IllegalArgumentException if the meeting was not found
     * @param id the id of the searched meeting
     * @return the meeting with the given id
     */
    public static Meeting getMeeting(String id) {
        if (!meetings.containsKey(id)) {
            throw new IllegalArgumentException("Meeting with id " + id + " can not be found");
        }
        return meetings.get(id).touch();
    }

    /**
     * Generates a number and checks if its already used. If it's used try to generate a new number.
     *
     * @return unic number
     */
    private synchronized static String getNextNumber() {
        String toReturn;
        String number = String.valueOf(Math.round(Math.random() * 89999) + 10000);
        if(meetings.containsKey(number)) {
           toReturn = getNextNumber();
        } else {
            toReturn = number;
        }
        return toReturn;
    }
}

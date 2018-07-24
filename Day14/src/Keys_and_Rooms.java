
import java.util.*;

import static org.junit.Assert.*;

public class Keys_and_Rooms {

    /*There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

            Initially, all the rooms start locked (except for room 0).

    You can walk back and forth between rooms freely.

            Return true if and only if you can enter every room.

            Example 1:

    Input: [[1],[2],[3],[]]
    Output: true
    Explanation:
    We start in room 0, and pick up key 1.
    We then go to room 1, and pick up key 2.
    We then go to room 2, and pick up key 3.
    We then go to room 3.  Since we were able to go to every room, we return true.
    Example 2:

    Input: [[1,3],[3,0,1],[2],[0]]
    Output: false
    Explanation: We can't enter the room with number 2.
    Note:

            1 <= rooms.length <= 1000
            0 <= rooms[i].length <= 1000
    The number of keys in all rooms combined is at most 3000.*/
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        room0.add(3);
        List<Integer> room1 = new ArrayList<>();
        room1.add(3);
        room1.add(0);
        room1.add(1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(0);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        assertFalse(canVisitAllRooms(rooms));


    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> keys = new Stack<Integer>();
        Set<Integer> total = new HashSet<Integer>();
        if (rooms == null || (rooms.get(0).size() == 0 && rooms.size() > 1)) {
            return false;
        }
        keys.add(0);
        total.add(0);
        while (!keys.isEmpty()) {
            List<Integer> curkeys = rooms.get(keys.pop());
            for (int key: curkeys) {
                if (!total.contains(key)) {
                    keys.add(key);
                }
                total.add(key);
            }
            if (total.size() == rooms.size()) {
                return true;
            }
        }
        return false;

    }

}

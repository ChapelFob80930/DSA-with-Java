class TimeMap {

    /*
     * Data Structure:
     *
     * key -> TreeMap(timestamp -> value)
     *
     * Example:
     *
     * set("foo", "bar", 1);
     * set("foo", "bar2", 4);
     * set("foo", "bar3", 8);
     *
     * map:
     *
     * {
     *   "foo" -> {
     *      1 -> "bar",
     *      4 -> "bar2",
     *      8 -> "bar3"
     *   }
     * }
     *
     * Why TreeMap?
     *
     * TreeMap automatically keeps timestamps sorted.
     *
     * We frequently need to answer:
     *
     * "What is the value associated with the
     * largest timestamp <= requested timestamp?"
     *
     * TreeMap provides floorEntry() which does exactly that.
     *
     * --------------------------------------------------
     * Binary Search Connection
     * --------------------------------------------------
     *
     * This problem is fundamentally a binary-search problem.
     *
     * Example:
     *
     * timestamps:
     *
     * [1, 4, 8]
     *
     * get("foo", 6)
     *
     * We want:
     *
     * Largest timestamp <= 6
     *
     * Answer = 4
     *
     * If we stored timestamps in an ArrayList,
     * we would perform binary search ourselves.
     *
     * TreeMap internally uses a self-balancing
     * Red-Black Tree and performs this search
     * in O(log n) time for us.
     *
     * So floorEntry() is conceptually doing the
     * same job as binary search:
     *
     * Find the rightmost timestamp <= target.
     */
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        /*
         * computeIfAbsent():
         *
         * If key exists:
         *     return its TreeMap
         *
         * If key doesn't exist:
         *     create a new TreeMap,
         *     store it,
         *     and return it.
         *
         * Equivalent code:
         *
         * if (!map.containsKey(key)) {
         *     map.put(key, new TreeMap<>());
         * }
         *
         * map.get(key).put(timestamp, value);
         */

        this.map.computeIfAbsent(key, k -> new TreeMap<>())
                .put(timestamp, value);

        /*
         * Example:
         *
         * set("foo", "bar", 1)
         *
         * {
         *   "foo" -> {
         *      1 -> "bar"
         *   }
         * }
         *
         * set("foo", "bar2", 4)
         *
         * {
         *   "foo" -> {
         *      1 -> "bar",
         *      4 -> "bar2"
         *   }
         * }
         */
    }

    public String get(String key, int timestamp) {

        /*
         * If key was never inserted,
         * answer must be an empty string.
         */
        if (!this.map.containsKey(key)) {
            return "";
        }

        /*
         * floorEntry(timestamp)
         *
         * Returns:
         *
         * Largest timestamp <= given timestamp
         *
         * Example TreeMap:
         *
         * {
         *   1 -> "bar",
         *   4 -> "bar2",
         *   8 -> "bar3"
         * }
         *
         * Queries:
         *
         * floorEntry(1)  -> (1, "bar")
         * floorEntry(4)  -> (4, "bar2")
         * floorEntry(6)  -> (4, "bar2")
         * floorEntry(8)  -> (8, "bar3")
         * floorEntry(10) -> (8, "bar3")
         * floorEntry(0)  -> null
         *
         * Visualization:
         *
         * timestamps:
         *
         * 1 ----- 4 ----- 8
         *          ^
         *
         * get("foo", 6)
         *
         * Largest timestamp <= 6 is 4.
         */

        Map.Entry<Integer, String> entry =
                this.map.get(key).floorEntry(timestamp);

        /*
         * If no timestamp <= requested timestamp exists,
         * floorEntry() returns null.
         *
         * Example:
         *
         * set("foo", "bar", 5);
         *
         * get("foo", 3);
         *
         * No timestamp <= 3 exists,
         * therefore return "".
         */

        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Time Complexity
 * ----------------
 *
 * set():
 * O(log n)
 *
 * Reason:
 * TreeMap insertion.
 *
 * get():
 * O(log n)
 *
 * Reason:
 * floorEntry() search.
 *
 * Space:
 * O(total set operations)
 *
 * --------------------------------------------------
 * Complete Example
 * --------------------------------------------------
 *
 * set("foo", "bar", 1);
 * set("foo", "bar2", 4);
 * set("foo", "bar3", 8);
 *
 * map:
 *
 * {
 *   "foo" ->
 *      1 -> "bar"
 *      4 -> "bar2"
 *      8 -> "bar3"
 * }
 *
 * get("foo", 6)
 *
 * Need:
 *
 * Largest timestamp <= 6
 *
 * timestamps:
 *
 * 1 ----- 4 ----- 8
 *          ^
 *
 * Answer:
 *
 * "bar2"
 *
 * --------------------------------------------------
 * Key Insight
 * --------------------------------------------------
 *
 * We are NOT searching for:
 *
 * Exact timestamp == target
 *
 * We ARE searching for:
 *
 * Largest timestamp <= target
 *
 * TreeMap.floorEntry() gives exactly that
 * in O(log n) time.
 */

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
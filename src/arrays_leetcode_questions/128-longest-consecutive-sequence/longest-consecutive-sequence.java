/*
--------------------------------------------------
Pattern: HashSet / Consecutive Sequence
--------------------------------------------------

Idea:
1. Store all numbers in a HashSet for O(1) lookup.
2. Only start counting from numbers that are the
   beginning of a sequence.
3. A number is the start of a sequence if (n - 1)
   does NOT exist in the set.
4. Keep extending the sequence while consecutive
   numbers exist.
5. Track the longest sequence length found.

Why check (n - 1)?
- Prevents counting the same sequence multiple times.
- Ensures each sequence is traversed exactly once.

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
Visualization Example 1
--------------------------------------------------

nums = [100,4,200,1,3,2]

HashSet:
{100,4,200,1,3,2}

n = 100
99 not present -> Start sequence
100
length = 1

n = 4
3 present -> NOT a start
Skip

n = 200
199 not present -> Start sequence
200
length = 1

n = 1
0 not present -> Start sequence

1 -> 2 -> 3 -> 4
length = 4

Longest = 4

--------------------------------------------------
Visualization Example 2
--------------------------------------------------

nums = [2,20,4,10,3,4,5]

HashSet:
{2,3,4,5,10,20}

n = 2
1 not present -> Start sequence

2 -> 3 -> 4 -> 5
length = 4

n = 3
2 present -> Skip

n = 4
3 present -> Skip

n = 5
4 present -> Skip

n = 10
9 not present -> Start sequence
length = 1

n = 20
19 not present -> Start sequence
length = 1

Longest = 4

--------------------------------------------------
Visualization Example 3
--------------------------------------------------

nums = [1,2,3,4,5]

HashSet:
{1,2,3,4,5}

n = 1
0 not present -> Start sequence

1 -> 2 -> 3 -> 4 -> 5
length = 5

All other numbers have predecessors,
so they are skipped.

Longest = 5

--------------------------------------------------
Key Insight
--------------------------------------------------

Every consecutive sequence has exactly one start.

Example:

1 -> 2 -> 3 -> 4

Only 1 qualifies because:
0 is absent

2, 3, and 4 are skipped because:
1, 2, and 3 already exist.

This avoids re-counting the same sequence.

Without the (n - 1) check:

Start at 1 -> count 4 numbers
Start at 2 -> count 3 numbers
Start at 3 -> count 2 numbers
Start at 4 -> count 1 number

Lots of redundant work.

With the (n - 1) check:

Start only at 1 -> count once.
*/

class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers for O(1) lookup
        Set<Integer> numSet = new HashSet<>();

        int longest = 0;

        for(int n : nums){
            numSet.add(n);
        }

        for(int n : numSet){

            /*
             Start counting only if n is the
             beginning of a sequence.

             Example:
             n = 1
             0 not present -> start

             n = 3
             2 present -> skip
            */
            if(!numSet.contains(n - 1)){

                int length = 1;

                // Extend sequence while next number exists
                while(numSet.contains(n + length)){
                    length++;
                }

                // Update longest sequence found
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
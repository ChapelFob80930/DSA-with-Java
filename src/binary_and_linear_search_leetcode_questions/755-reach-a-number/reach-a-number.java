class Solution {
    public int reachNumber(int target) {

        // Moving to +target or -target requires the same number of moves,
        // so convert everything to the positive side.
        target = Math.abs(target);

        int k = 0;

        // Keep taking moves of length 1, 2, 3, ... , k
        // until we reach or cross the target.
        //
        // Example: target = 5
        // Move 1 -> remaining = 4
        // Move 2 -> remaining = 2
        // Move 3 -> remaining = -1 (crossed target)
        //
        // After the loop:
        // target = originalTarget - (1 + 2 + ... + k)
        while (target > 0) {
            target -= ++k;
        }

        // If the overshoot is even, we can flip the direction
        // of some move(s) and exactly reach the target.
        //
        // Why?
        // Flipping a move of length x changes the final position by 2*x.
        // Therefore only an EVEN difference can be corrected.
        //
        // Example:
        // target = 3
        // sum = 1+2 = 3
        // overshoot = 0 (even)
        // answer = 2
        //
        // Example:
        // target = 5
        // sum = 1+2+3 = 6
        // overshoot = 1 (odd)
        // cannot fix yet
        if (target % 2 == 0) {
            return k;
        }

        // Overshoot is odd.
        //
        // We need 1 or 2 extra moves until the overshoot becomes even.
        //
        // Example: target = 5
        // After loop:
        // k = 3, overshoot = 1 (odd)
        //
        // Take move 4:
        // overshoot = 1 + 4 = 5 (odd)
        //
        // Take move 5:
        // overshoot = 5 + 5 = 10 (even)
        //
        // Answer = 5
        //
        // Compact parity trick:
        // k even -> need 1 more move
        // k odd  -> need 2 more moves
        return k + 1 + k % 2;
    }
}
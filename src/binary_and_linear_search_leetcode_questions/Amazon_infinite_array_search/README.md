# Find Position of an Element in an Infinite Sorted Array

**Difficulty:** Medium

Given a sorted array of integers `arr[]` that is considered to be infinite, and an integer `target`, return the index of `target` if it exists in the array. Otherwise, return `-1`.

Since the size of the array is unknown, you cannot use the array length directly.

You must write an algorithm with **O(log n)** time complexity.

---

## Example 1

```text
Input: arr = [3,5,7,9,10,90,100,130,140,160,170], target = 10

Output: 4
```

### Explanation
`10` is present at index `4`.

---

## Example 2

```text
Input: arr = [2,5,7,9], target = 3

Output: -1
```

### Explanation
`3` is not present in the array.

---

## Example 3

```text
Input: arr = [1,2,4,8,16,32,64,128], target = 64

Output: 6
```

### Explanation
`64` is present at index `6`.

---

## Constraints

- `1 <= arr.length <= 10^5`
- `-10^9 <= arr[i], target <= 10^9`
- `arr` is sorted in ascending order.
- Assume the array size is unknown.

---

## Hint

First, find a range where the target may exist by expanding the search window exponentially.  
Then apply Binary Search within that range.
# Rotation Count in Rotated Sorted Array

## Problem Statement

You are given an integer array `nums` consisting of unique elements sorted in strictly increasing order and then rotated to the right `k` times.

A right rotation moves the last element of the array to the first position and shifts all remaining elements one position to the right.

Return the value of `k`, representing the number of right rotations performed on the original sorted array.

---

## Examples

### Example 1

#### Input
```text
nums = [15, 18, 2, 3, 6, 12]
```

#### Output
```text
2
```

#### Explanation

Original sorted array:

```text
[2, 3, 6, 12, 15, 18]
```

After 1 right rotation:

```text
[18, 2, 3, 6, 12, 15]
```

After 2 right rotations:

```text
[15, 18, 2, 3, 6, 12]
```

Therefore, the rotation count is **2**.

---

### Example 2

#### Input
```text
nums = [7, 9, 11, 12, 5]
```

#### Output
```text
4
```

#### Explanation

Original sorted array:

```text
[5, 7, 9, 11, 12]
```

After 4 right rotations:

```text
[7, 9, 11, 12, 5]
```

Therefore, the rotation count is **4**.

---

### Example 3

#### Input
```text
nums = [5, 7, 9, 11, 12]
```

#### Output
```text
0
```

#### Explanation

The array is already sorted and has not been rotated.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- All elements in `nums` are unique.
- `nums` was originally sorted in strictly increasing order and then rotated.

---

## Follow-up

Can you solve it in **O(log n)** time?

---

## Hint

The number of right rotations is equal to the index of the **smallest element** in the rotated array.

For example:

```text
nums = [15, 18, 2, 3, 6, 12]
                ^
            smallest element
```

The smallest element `2` is at index `2`, so the array has been rotated **2 times**.

You can find the smallest element efficiently using **Binary Search**.
##### 768. Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

##### What is the most number of chunks we could have made?

1. Example:
```
[1,2,3,4,5] -> 5
[5,4,3,2,1] -> 1
[0,0,0,0,0] -> 5
[0,0,0,1,1] -> 5
[2,1,4,3,5] -> 3
```

2. Intuition:
To split a chunk, all numbers m the left part should be smaller than the right part's.

```
2,1,4,3,5
   |   |            | : splitable
```

3. Algorithm:
```java  
    public int maxChunksToSorted(int[] arr) {
        int[] minRight = new int[arr.length];
        int maxLeft = arr[0];
        minRight[minRight.length-1] = arr[arr.length-1];
        
        for(int i = minRight.length-2; i >= 0; i--){
            minRight[i] = Math.min(arr[i], minRight[i+1]);
        }
        
        int res = 0;
        for(int i = 0; i < arr.length-1; i++){
            maxLeft = Math.max(arr[i], maxLeft);
            if(maxLeft <= minRight[i+1]) res++;
        }
        
        return res+1; //for the last element of the array.
    }
```

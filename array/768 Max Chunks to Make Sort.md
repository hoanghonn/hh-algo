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
        
        return res+1;
    }

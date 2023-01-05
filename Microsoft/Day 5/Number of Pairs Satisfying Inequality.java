// Problem : Number of Pairs Satisfying Inequality 

// Input/Output:
// Input: nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
// Output: 3
// Explanation:
// There are 3 pairs that satisfy the conditions:
// 1. i = 0, j = 1: 3 - 2 <= 2 - 2 + 1. Since i < j and 1 <= 1, this pair satisfies the conditions.
// 2. i = 0, j = 2: 3 - 5 <= 2 - 1 + 1. Since i < j and -2 <= 2, this pair satisfies the conditions.
// 3. i = 1, j = 2: 2 - 5 <= 2 - 1 + 1. Since i < j and -3 <= 2, this pair satisfies the conditions.
// Therefore, we return 3.

// Approach : Using Merge Sort
// nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff

// written as

// nums1[i] - nums2[i] <= nums1[j] - nums2[j] + diff

// let,
// v[i] = nums1[i] - nums2[i] 
// v[j] = nums1[j] - nums2[j]
// count all pairs where v[i]<=v[j]+diff and i<j (same as counting sort /merge sort)

// Code:

class Solution {
    int d;
    public long mergeSort(ArrayList<Integer> arr, int st, int mid, int en){
        long cnt=0;
        int i= st;
        int j = mid+1;
        while(i<=mid && j<=en){
            if(arr.get(i)<=arr.get(j)+d){
                cnt+= (en-j+1);
                i++;
            }
            else{
                j++;
            }
        }
        Collections.sort(arr.subList(st,en+1));
        return cnt;
    }
    public long merge(ArrayList<Integer> arr, int st, int en){
        long cnt=0;
        if(st<en){
            int mid = st + (en-st)/2;
            cnt+= merge(arr,st,mid);
            cnt+= merge(arr,mid+1,en);
            cnt+= mergeSort(arr,st,mid,en);
        }
        return cnt;
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        ArrayList<Integer> arr = new ArrayList<>();
        d=diff;
        for(int i=0;i<nums1.length;i++){
            arr.add(nums1[i]-nums2[i]);
        }
        return merge(arr,0,arr.size()-1);
    }
}

// Time Complexity : O(nlogn)
// Space COmplexity : O(n)
public class cyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int s, int e){
        if(s>e)
            return;
        int S = s;
        int E = e;
        int m = s +(e-s)/2;
        int pivot = arr[m];

        while(s<e){
            while(nums[s] < pivot){
                S++;
            }
            while(nums[e] > pivot){
                E--;
            }
            if( S <= E){
                int temp = arr[S];
                arr[S] = arr[E];
                arr[E] = temp;
                S++;
                E--:
            }
        }
//        now we should call the recuring function for both the half of the pivot
        sort(arr, s, E);
        sort(arr, S, e)

    }
}

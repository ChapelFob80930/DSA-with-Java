package binary_operators_and_number_systems;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(unique(arr));
    }

    private static int unique(int[] arr) {
        int ans = 0;

        for(int n : arr){
            ans = n ^ ans;
        }

        return ans;
    }
}

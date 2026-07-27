package recursion;

import java.util.ArrayList;

public class find_num_of_dice_roll_with_target_sum {
    public static void main(String[] args) {
        System.out.println(dice("", 4));
        System.out.println(diceFace("", 4, 3));
    }

    static ArrayList<String> dice(String p, int target){
        ArrayList<String> ans = new ArrayList<>();
        if(target == 0){
            ans.add(p);
            return ans;
        }

        for(int i = 1; i<=target; i++){
            ans.addAll(dice(p + i, target - i));
        }

        return ans;
    }

    static ArrayList<String> diceFace(String p, int target, int face){
        ArrayList<String> ans = new ArrayList<>();
        if(target == 0){
            ans.add(p);
            return ans;
        }

        for(int i = 1; i<=face && i<=target; i++){
            ans.addAll(diceFace(p + i, target - i, face));
        }

        return ans;
    }
}

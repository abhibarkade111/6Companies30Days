// Problem: Bulls and Cows

// Input/Output:
// Input: secret = "1807", guess = "7810"
// Output: "1A3B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1807"
//   |
// "7810"

// Apparoch : Using HashMap
// As per given condition in the question We perform operation on the string
// Traverse the string if same character found then increase the A and if mismatch is there then add it in map ans aslo maintain the frequency of the character
// Now traverse the another string and check whether charcter is mismatched and presnt in previous string if present then increse B and decrease frequency of charcacter from map 
// return A+"A"+B+"B";

// Code:

class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int A=0,B=0;
        for(int i=0;i<secret.length();i++){
            if(guess.charAt(i)==secret.charAt(i)){
                A++;
                continue;
            }
            hm.put(secret.charAt(i), hm.getOrDefault(secret.charAt(i),0)+1);
        }
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i)!=secret.charAt(i)){
                if(hm.containsKey(guess.charAt(i))){
                    B++;
                    hm.put(guess.charAt(i), hm.get(guess.charAt(i))-1);
                    if(hm.get(guess.charAt(i))==0) hm.remove(guess.charAt(i));
                }
            }
        }
        return A+"A"+B+"B";

    }
}

// Time Complexity - O(2n)
// Space Complexity - O(n)
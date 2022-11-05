package leetcode.solution.ready;

//
// Игра в камни: Можно убрать до 3 камней включительно, выиграет тот, кто уберет последний камень
// https://leetcode.com/problems/nim-game/
//
public class Solution0292 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Nim Game.
    //Memory Usage: 40.9 MB, less than 42.56% of Java online submissions for Nim Game.
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}

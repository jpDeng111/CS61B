public class OffByOne implements CharacterComparator{

    public OffByOne() {
        int offByOne = 0;
    }

    @Override
    public boolean equalChars(char x, char y) {
         int difference = Math.abs(x-y);

         if (difference == 1) {
             return true;
         } else{
             return false;
         }
    }
}

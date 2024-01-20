public class OffByN implements CharacterComparator{

    private int difference = 0;
    public OffByN(int N) {
        difference = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diffOfChars = Math.abs(x - y);
        if (diffOfChars == difference) {
            return true;
        } else {
            return false;
        }
    }


}

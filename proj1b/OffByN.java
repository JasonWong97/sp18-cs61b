/**
 * @ClassName OffByN
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/6/20 4:59 下午
 * @Version V1.0
 **/
public class OffByN implements CharacterComparator {

    private int n;

    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y) == n || (y - x) == n;
    }
}

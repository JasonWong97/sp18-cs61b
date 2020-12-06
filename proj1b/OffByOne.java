/**
 * @ClassName OffByOne
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/6/20 4:23 下午
 * @Version V1.0
 **/
public class OffByOne implements CharacterComparator {


    @Override
    public boolean equalChars(char x, char y) {
        return (x - y) == 1 || (y - x) == 1;
    }
}

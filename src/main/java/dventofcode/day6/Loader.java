package dventofcode.day6;

public class Loader {

    private static final String MESSAGE = "wzsspbssbhshchmmrmprmrfrsfrrjhjphjjtppbfflqfqppdhdbhdhbbjgghgzgsgfsfhfhvvwcwhwwnppsbsggqnnvvtffpssjfjnnltntdtdddptprppjmmqssrlrplllfrrzggbmmlmnmtnnzddfdgfdfsstbstbbzcbbcjcvvfwwwzlzssglsgllnbnmbnmbbgmmppmwwsrrzqqvgqgnqnmmswwrnnbsnnbdbwwqnwqnwwzzqwzqzjqqwbqbccjcwwjlwjwppqfqjffwddrzrjzrjzzzhchjjlqqrggzvvnlvnvjvhvnvjvbbvdvldldbbwddtsscbbhccmbmbppbmmgjggcjjlrrwjwtjwwmffgddwvdvbdbvvhchmhmdmwwbjbjcbbcmbmmslmlslsjjrnrjrjpjcjgcjcjbbwsbsbfssjzsjsggcmcsswgssbbqpbqqdsdqqztzmzpmpbmbvbjjtrjtthwhbhnbhnbnssvpvsppgrrcwrrmqqhpphrpphchvhphqhbqbtttllsrlsrshrrmhmvvrmrnngbgnbnpbprrrftfjtjwwmrmvmcmvmrmwmssrccfbbhppjbpbwbqwbqbzzfmzmtttjbbvcvppmwwrbbzsbzbfzfdzzhrhzhvvsqvsqsnslljwllqlwllvccnttzhtzzpspqspqsqgsssvnsvshvsvqvnvlldbbfdfmmpbpgphhpqhpppchhbfbrfrllntnznrrhdrdhhdhjjgwwqhhfssjbjwjqqbffvvcrchccwmcwcllljtjrrqgrrdcrddvfvwvzzjqqcffgjgzzdhdwdssffjjhccggmtmltlhtthzhvhlvlddsfsbbtjbjcbjcjzcjjpfjfzzpnnbtbqtbqtqptpnplllbzbllhbllnqnttpddqvdqvqmmjnjggnnnhqqfcqcffqppdgpddvqddmhmrhrtrmrzmzhzpzlzqlqpqhphrpppjqqppzbzmmjgggqtggtjthhlclnclcnccmcppdcpddqrrfgrgbbhwhdhrrqtqpqjpqjpqjqqmcqmccnngqqqmtqtssnvnzvvpcpwcwwqcqqqfcqffsvsmvmttttmrrzssghgssjmsmbmvvwggggzhhfvdpgjmmvzbfjghqhrfbpmbvjzwvfmcthrqwdhghpwsspmhpqnmwhjzpnlzfnvhdnnrqwnvctbmjqzhqrpjlwrssdlwqzmsfrfzmgjhnwwnwczswnhsdbvqbmdlvntsdrhrjjcjjhpbblgwhjwdcdjtpvtmslwvncwdjbwzvbpzbvddvssnrhtshrcvnhqnpmjzfswqbbrztnwjcpflfbhnphfwmjvnvtswgfttgjcqcngmmwjlfsprwfcfwcmgrgbnqmzbtzbtbztngvrzpsnrzvhbsdjnzpwwzllgnfdrlwpmnrznqsqcmvnfbnhqjddvcjmtgbpbmsgqdqzflmlmqncmhwltrmdmgnwpfwddrdpfhsgsnggchzjhgpwrsmdzgjtrgmnprhbwbcbpzbdvvstfqcnqzbdjqpmrdbtgcthtclftghhmnrzrjqqsbndhpvmdpfpwdlhvmczvdfgvpqclssvlhqnhlcfnfbvtspdzmgzdctvpdcwchtqhpsgmmblspjdlvgblbpgrfrgnqqsphcsrgfsdmpqscbjmnqrfbcwfthdtswbzthpnvsfbntnbmmgpfzlqwhppvvdrmwbqzbgppbgsqmjfqtmntgwpnccthftwdmvwmnchlbjhsnmbhndczbrhhjpbvnjdzrcndbbmfwfwsjwfgbqhwhrsvlngsbhhlrdjzzbmjpsqhlpzwcsntjhlmngblspmsjrjwsjsrqwnrcwsmcsbmpjwrthbqhrschrmrppnnbmjbvjzlmzsrfdwqlfnfjljftjvzsqdwlhbblqcdlqjbprpcllhlhmwrbrlgfrcqshrtjpnmhljttdvpfnhdjqvjhhfczwvbzqgnzgljcfrbpgwnfhfchwzqmqqzpbcdpqmnbrppzblnnzqrfnmgtljwnfgzwvnjppdbdhbznvpgwhbdjjvlspgwgjsmfsvllpgwlfnnptmwnfsshjjvqzjwrqpvmsphpmftqdllqqdzcjwfvpftgvspprdwvvcnglmbpntghntdwpjvvsppgjvnbjgvtzchtqtwbddncsbrfcvrnvlggvwgmmnfzrswnzjrwthzmdsmzqmzsnrqsnslnhmfqljnnnzshqfqshrhhjmnhdgphctswdbhnrcgnzmmzqpjqbtdfhhltsmvvtntbgsznshhsghblhlhqpmdcfhmnfzvhgnfsfflcfwbfqzmccrjdpfvphtqbrdnzjfmfhbzqcpdnjdcgwprvchlzrcvrghgjqncjvnndbcshntrfsbsnmjlhclnzpfdgztflcpwqpnvlscfndwqzfvcmpgfncszpmwcsrdbrrhdjvmthslfvmlgpqhlgwhqnjljcvhswbsbqfrfhvzwjvdmhzsgbmbmfnbpclqdwhvrlpppszptjvwtvdmfltfqqgjttdggcvllblnnhjqnjzhvpgpzzpzwbpjqbthnjjlmsjgjzqwnjlqrcdmmvsldtcrzqdrcmwqhnhfghdlmzwcspgmlpzhbdsmlwlqnhhvcvdfzmvfwpbfmjtdllprfqzzjpbrshdzgspsrlrwrhdpmznzzqngwrzqpmtwgbsswrnnnfctjhbcftnslsqwjvmfwfdvfqcnsvfsvgstgbzpmljjtlvtnfsdzpvcgbjqwgbgzqbjfgltqvnhffflsbjzfqfrfbssrvvwqvqptmhrbgllqjwptrzgvqgccsrvbgtvmzfzlmtqrgfwhzddsptclbhjlwqfntvjqdvcddnffmbtqrnsvtmlvljcqdsrpggcmqvmmlzwwbgznhblwzjdppvtqzjvcmtfzhdzjplrdbrfrgzpldvnsgqlbwbmfvrbgwzmjmmqdfgwtbgtzmdqnvqbwvcfjhddqvnjtjlhhjnltbtqqvblwlmglrqcrcfjvdntrnqzzbmrjqglmrdcjgnshcghtprjqqsdrmgdnzmzcfqqdtjtrqgtqtgrpmmgzjtcrznmqccjbdpbvrnnbmbzvgdcnrczbctbrsrrqrjnfcdpzlnngwvcdtbbgssvhpptntqdzhcqtlpvzjbfgzggrgrcgtdfjbwdcrpztnfcdbscnlmqmwcbmtnddgbmhwsgvcfdcmhlsvtnqtmrnsjzhppgwvzlmhwwmpfjzrfbhsgntzrdhwswrnfmmmczqrvdrqnhgrvqbdddhglwsftsljvgbnjqfwfzsspdqvgsnlgfsfpvdrjhzcldtrmjjrmdhvvfrjldhhtqnvsvlldjpjbpwstfsmrpmbqbnnpvqtbgjvblthbmwqtfcfgnjscvtbvlqcmlhffpzgjzfscsqwnhrjhvbrrzwqvbjwtwhtqsdbssfgncppnsfgfltdcbjqjzqqtprsbvjzhmchnltvmbsvpvhgzhfhbrnttsqbcmwpdnwqqgdrjrdwdhtzwsmcdffqgsddvbzfjhtfhtnfdbfrwmdtcqshfjrcpswzcptgwgmctpmzjdbqlmqwthmnfplmctpsslcsdtqpqhjtmjdnmnqnjgchwstsmtpvsmgpsbfgwqnzhrdgdvcdlcldfcmjvsdldgbmhltjhczffwmzqssnhfnwftfgpshntjbpjdffjpcmcpwhclrrwqcqzmntjglzgcfrplfpvprtpvpjdlcrfwrtrzdzmhsrsmdcpqqrqgvfpdbmzbzqdfhpplmgfrdghclbclgswvwhhdvcpmpzflpffmptcrwglftztccrpbrvmpnqmqdgjgrrlbtqtvgcjpljttwtdslqjqlsdpblgrqbrtbmtblfbqtbvsqhpqzpqfhjqpmjrmcvqmsbbpjpdncgnjftclbltwszrrfzqbjcdtphcvpmbhppvwjwlprgmghrjzzgnvzlvghnjbzqjpdgzfsnjchpbzqdzpsjmsrvvqwjcpwznlpbjldlrdfqtrzhqzcnpjqbbbf";

    public static final String TEST_04_05 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
    public static final String TEST_04_06 = "nppdvjthqldpwncqszvftbrmjlhg";
    public static final String TEST_04_10 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
    public static final String TEST_04_11 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

    public static final String TEST_14_19 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
    public static final String TEST_14_23 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
    public static final String TEST_14_23_2 = "nppdvjthqldpwncqszvftbrmjlhg";
    public static final String TEST_14_29 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
    public static final String TEST_14_26 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

    public static final int WINDOW = 14;

    public static void main(String[] args) {
        int[] frame = new int[26];
        var s = MESSAGE;
        char[] chars = s.toCharArray();
        int tail = 0;
        int res = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int key = c - 'a';
            frame[key] = frame[key] + 1;
            if (i - WINDOW + 1 > tail) {
                char tailChar = chars[tail];
                int tailKey = tailChar - 'a';
                frame[tailKey] = frame[tailKey] - 1;
                tail++;
            }
            int total = 0;
            for (int j = 0; j < 26; j++) if (frame[j] == 1) total++;
            if (total == WINDOW) {
                res = i + 1;
                break;
            }
        }
        System.out.println(res);
    }

}

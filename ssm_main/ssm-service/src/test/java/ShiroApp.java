import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class ShiroApp {
    //md5加密,生成32位加密字符串
    @Test
    public void md5_1() {
        Md5Hash md5Hash = new Md5Hash("1234");
        System.out.println("加密" + md5Hash);
    }
    //加密加盐
    @Test
    public void md5_2() {
        String salt = "AAA";
        Md5Hash md5Hash = new Md5Hash("1234", salt);
        System.out.println("加密加盐" + md5Hash);
    }
    //加密加盐(随机盐)
    @Test
    public void md5_3() {
        //随机盐
        SecureRandomNumberGenerator srn = new SecureRandomNumberGenerator();
        String salt = srn.nextBytes().toHex();
        System.out.println(new Md5Hash("1234", salt));
    }
    //加密 加盐(随机盐) 加迭代次数
    @Test
    public void md5_4() {
        //随机盐
        SecureRandomNumberGenerator srn = new SecureRandomNumberGenerator();
        String salt = srn.nextBytes().toHex();
        Md5Hash md5Hash = new Md5Hash("1234", salt, 3);//迭代3次
        System.out.println(md5Hash);
    }
}

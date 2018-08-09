import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 *spring security中的BCryptPasswordEncoder方法采用
 * SHA-256 +随机盐+密钥对密码进行加密。
 * SHA系列是Hash算法，不是加密算法，使用加密算法意味着可以解密（这个与编码/解码一样），
 * 但是采用Hash处理，其过程是不可逆的
 * （1）加密(encode)：注册用户时，使用SHA-256+随机盐+密钥把用户输入的密码进行hash处理，
 *     得到密码的hash值，然后将其存入数据库中。
 * （2）密码匹配(matches)：用户登录时，密码匹配阶段并没有进行密码解密（因为密码经过Hash处理，
 *     是不可逆的），而是使用相同的算法把用户输入的密码进行hash处理，得到密码的hash值，
 *     然后将其与从数据库中查询到的密码hash值进行比较。如果两者相同，说明用户输入的密码正确。
 */
public class SpringBCry {
    @Test
    public void spring() {
        //加密器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String str1 = encoder.encode("123");
        String str2 = encoder.encode("123");
        String str3 = encoder.encode("123");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        //判断
      boolean f1 =  encoder.matches("123","$2a$10$qGfGfjzeJDECEfAxatYp7.3L/czh8BHj6eVfVZLW/u4H438/fqmqG");
      boolean f2 =  encoder.matches("123","$2a$10$TZYzEzhFywt.0B.Jshncj.MqukQRnc9ySgWuOkDuS/H8wywS4FXqK");
      boolean f3 =  encoder.matches("123","$2a$10$6q3GndLLX76sA4oLtxXNWe3a93mlmCUWAJh9Wk3MU3N4pYV23DBKW");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }
}

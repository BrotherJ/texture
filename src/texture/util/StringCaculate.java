package texture.util;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * �������� . ��ʽ����
 *
 */
public class StringCaculate {
  
    private Stack<BigDecimal> numbers = new Stack<BigDecimal>();
  
    private Stack<Character> chs = new Stack<Character>();
  
    /**
     * �Ƚϵ�ǰ��������ջ��Ԫ�ز��������ȼ��������ջ��Ԫ�����ȼ��ߣ��򷵻�true�����򷵻�false
     *
     * @param str
     *            ��Ҫ���бȽϵ��ַ�
     * @return �ȽϽ�� true������ջ��Ԫ�����ȼ��ߣ�false������ջ��Ԫ�����ȼ���
     */
    private boolean compare(char str) {
        if (chs.empty()) {
            // ��Ϊ��ʱ����Ȼ ��ǰ���ȼ���ͣ����ظ�
            return true;
        }
        char last = (char) chs.lastElement();
        switch (str) {
        case '*': {
            // '*/'���ȼ�ֻ��'+-'��
            if (last == '+' || last == '-')
                return true;
            else
                return false;
        }
        case '/': {
            if (last == '+' || last == '-')
                return true;
            else
                return false;
        }
            // '+-'Ϊ��ͣ�һֱ����false
        case '+':
            return false;
        case '-':
            return false;
        }
        return true;
    }
  
    public BigDecimal caculate(String st) {
        StringBuffer sb = new StringBuffer(st);
        StringBuffer num = new StringBuffer();
        String tem = null;
        char next;
        while (sb.length() > 0) {
            tem = sb.substring(0, 1);// ��ȡ�ַ����ĵ�һ���ַ�
            sb.delete(0, 1);
            if (isNum(tem.trim())||tem.equals(".")) {
                num.append(tem);// ��������֣��������num����
            } else {
  
                if (num.length() > 0 && !"".equals(num.toString().trim())) {// ����ȡ���ַ���������ʱ������Ϊnum�з��õ�ʱһ�����������֣�
                    // ��123+1,����ȡ��+ʱ��ǰ���123������Ϊ��һ����������
                    BigDecimal bd = new BigDecimal(num.toString().trim());
                    numbers.push(bd);
                    num.delete(0, num.length());
                }
                // ���chsΪ�գ�����Ϊ��ʱ��һ���ַ�ֱ�ӷ���
                if (!chs.isEmpty()) {
                    // ����ǰ����������ȼ����ڻ���С��ջ����Ԥ���ʱ��������.
                    // ����,1+2+3,����ȡ��2,3֮��ġ�+����1,2֮���"+"���ȼ����ʱ�������ȼ���1+2��ʹ����3+3
                    // ͬ����1*2+3,����ȡ��2,3֮��ġ�+����1,2֮���"*"���ȼ�С�������ȼ���1*2��ʹ����2+3
  
                    while (!compare(tem.charAt(0))) {
                        caculate();
                    }
                }
                // ������ջҲΪ��ʱ,������ʽ�ĵ�һ������Ϊ����ʱ
                if (numbers.isEmpty()) {
                    num.append(tem);
                } else {
                    chs.push(new Character(tem.charAt(0)));
                }
                // �жϺ�һ���ַ��Ƿ�Ϊ��-���ţ�Ϊ"-"��ʱ����Ϊ����Ϊ����
                // ���� 1*2*(-5)����Ϊ�����㲻����()����˽�����дΪ1*2*-5,���������뽫"-"��Ϊ�Ǹ�������ʽ���Ǽ���
                next = sb.charAt(0);
                if (next == '-') {
                    num.append(next);
                    sb.delete(0, 1);
                }
  
            }
        }
        // ����ǰ�潫���ַ���ջʱ����ͨ����ȡ����Ϊʱ�������������һ������û�з���ջ�У���˽��������ַ���ջ��
        BigDecimal bd = new BigDecimal(num.toString().trim());
        numbers.push(bd);
        // ��ʱ����ջ�����ֻ��2�����ţ�����ջ���÷������ȼ��ߣ�������
        while (!chs.isEmpty()) {
            caculate();
        }
        return numbers.pop();
    }
  
    private void caculate() {
        BigDecimal b = numbers.pop();// �ڶ���������
        BigDecimal a = null;// ��һ��������
        a = numbers.pop();
        char ope = chs.pop();
        BigDecimal result = null;// ������
        switch (ope) {
        // ����ǼӺŻ��߼��ţ���
        case '+':
            result = a.add(b);
            // ������������������ջ
            numbers.push(result);
            break;
        case '-':
            // ������������������ջ
            result = a.subtract(b);
            numbers.push(result);
            break;
        case '*':
            result = a.multiply(b);
            // ������������������ջ
            numbers.push(result);
            break;
        case '/':
            result = a.divide(b,2,BigDecimal.ROUND_HALF_EVEN);// ������������������ջ
            numbers.push(result);
            break;
        }
    }
  
    private boolean isNum(String num) {
        return num.matches("[0-9]");
    }
      
    /**
     *
     * ����������
     * ���������������ŵ���������û�д����ŵ�������
     */
        public BigDecimal parse(String st) {
            int start = 0;
            StringBuffer    sts = new StringBuffer(st);
            int end = -1;
            while ((end = sts.indexOf(")")) > 0) {
                String s = sts.substring(start, end + 1);
                int first = s.lastIndexOf("(");
                BigDecimal value = caculate(sts.substring(first + 1, end));
                sts.replace(first, end + 1, value.toString());
            }
            return caculate(sts.toString());
        }
  
    public static void main(String[] args) {
    	//C+Mn/6+(Cr+Mo+V)/5+(Ni+Cu)/15
    	//Cr+3.3xMo+16xN
    	String ss = "0.13+5/6+(1+2+3)/5+(1+2)/15";
//    	String ss = "1+3.3*1+16*1";
        StringCaculate caculate = new StringCaculate();
        System.out.println(caculate.parse(ss));
    }
}
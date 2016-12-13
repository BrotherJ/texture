package texture.domain;

/**
 * 机械性能
 * @author infodba
 *
 */
public class Mechanical {

	/**抗拉**/
	private double kl;
	private double kl_min;
	private double kl_max;
	/**屈服**/
	private double qf;
	private double qf_min;
	private double qf_max;
	/**延伸**/
	private double ysh;
	private double ysh_min;
	private double ysh_max;
	/**收缩**/
	private double ss;
	private double ss_min;
	private double ss_max;
	/**硬度**/
	private double yd;
	private double yd_min;
	private double yd_max;
	
	/**硬度单位  HB 还是HRC**/
	private String yddw;
	
	/**冲击温度**/
	private String cjwd;
	
	/**实际温度**/
	private String sjwd;
	
	/**冲击平均值**/
	private String cj_avg;

	/**冲击最小值**/
	private String cj_min;
	
	/**冲击值1**/
	private String cjz1;
	/**冲击值2**/
	private String cjz2;
	/**冲击值3**/
	private String cjz3;

	public String getCjwd() {
		return cjwd;
	}
	public void setCjwd(String cjwd) {
		this.cjwd = cjwd;
	}
	public String getCj_avg() {
		return cj_avg;
	}
	public void setCj_avg(String cj_avg) {
		this.cj_avg = cj_avg;
	}
	public String getCj_min() {
		return cj_min;
	}
	public void setCj_min(String cj_min) {
		this.cj_min = cj_min;
	}
	public String getCjz1() {
		return cjz1;
	}
	public void setCjz1(String cjz1) {
		this.cjz1 = cjz1;
	}
	public String getCjz2() {
		return cjz2;
	}
	public void setCjz2(String cjz2) {
		this.cjz2 = cjz2;
	}
	public String getCjz3() {
		return cjz3;
	}
	public void setCjz3(String cjz3) {
		this.cjz3 = cjz3;
	}
	public double getKl() {
		return kl;
	}
	public void setKl(double kl) {
		this.kl = kl;
	}
	public double getQf() {
		return qf;
	}
	public void setQf(double qf) {
		this.qf = qf;
	}
	public double getYsh() {
		return ysh;
	}
	public void setYsh(double ysh) {
		this.ysh = ysh;
	}
	public double getSs() {
		return ss;
	}
	public void setSs(double ss) {
		this.ss = ss;
	}
	public double getYd() {
		return yd;
	}
	public void setYd(double yd) {
		this.yd = yd;
	}
	
	
	public double getKl_min() {
		return kl_min;
	}
	public void setKl_min(double kl_min) {
		this.kl_min = kl_min;
	}
	public double getKl_max() {
		return kl_max;
	}
	public void setKl_max(double kl_max) {
		this.kl_max = kl_max;
	}
	public double getQf_min() {
		return qf_min;
	}
	public void setQf_min(double qf_min) {
		this.qf_min = qf_min;
	}
	public double getQf_max() {
		return qf_max;
	}
	public void setQf_max(double qf_max) {
		this.qf_max = qf_max;
	}
	public double getYsh_min() {
		return ysh_min;
	}
	public void setYsh_min(double ysh_min) {
		this.ysh_min = ysh_min;
	}
	public double getYsh_max() {
		return ysh_max;
	}
	public void setYsh_max(double ysh_max) {
		this.ysh_max = ysh_max;
	}
	public double getSs_min() {
		return ss_min;
	}
	public void setSs_min(double ss_min) {
		this.ss_min = ss_min;
	}
	public double getSs_max() {
		return ss_max;
	}
	public void setSs_max(double ss_max) {
		this.ss_max = ss_max;
	}
	public double getYd_min() {
		return yd_min;
	}
	public void setYd_min(double yd_min) {
		this.yd_min = yd_min;
	}
	public double getYd_max() {
		return yd_max;
	}
	public void setYd_max(double yd_max) {
		this.yd_max = yd_max;
	}
	
	public String getYddw() {
		return yddw;
	}
	public void setYddw(String yddw) {
		this.yddw = yddw;
	}
	public String getSjwd() {
		return sjwd;
	}
	public void setSjwd(String sjwd) {
		this.sjwd = sjwd;
	}
	
	
}
